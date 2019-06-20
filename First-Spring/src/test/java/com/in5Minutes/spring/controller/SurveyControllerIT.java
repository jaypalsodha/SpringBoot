package com.in5Minutes.spring.controller;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.in5Minutes.spring.Application;
import com.in5Minutes.spring.model.Question;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

	@LocalServerPort
	private int port;
	TestRestTemplate template = new TestRestTemplate();
	private HttpHeaders headers;

	@Before
	public void beforeTest() {
		headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	}

	@Test
	public void retriveQuestions() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = template.exchange(createUrlWithPort("/Surveys/1/Questions/1"), HttpMethod.GET,
				entity, String.class);

		JSONAssert.assertEquals("{\"id\":\"1\"}", response.getBody(), true);

	}

	@Test
	public void addQuestion() throws JSONException {

		List<String> asList = Arrays.asList("India", "China", "Pakistan", "Russia");
		Question q1 = new Question("1", "Largest conuntry in the world?", "Russia", asList);

		HttpEntity<Question> entity = new HttpEntity<Question>(q1, headers);

		ResponseEntity<String> response = template.exchange(createUrlWithPort("/Surveys/1/Question"), HttpMethod.POST,
				entity, String.class);
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		assertTrue(actual.contains("/Surveys/1/Question"));

	}

	private String createUrlWithPort(String otherUrl) {
		return "http://localhost:" + port + otherUrl;
	}
}
