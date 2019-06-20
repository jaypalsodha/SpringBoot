package com.in5Minutes.spring.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in5Minutes.spring.model.Question;
import com.in5Minutes.spring.service.SurveyService;

@RestController
public class SurveyController {

	@Autowired
	private SurveyService surveyService;

	@GetMapping("/Surveys/{surveyId}/Questions")
	public List<Question> retriveQuestionsForSurvey(@PathVariable String surveyId) {
		return surveyService.retriveQuestions(surveyId);
	}

	@GetMapping("/Surveys/{surveyId}/Questions/{questionId}")
	public Question retriveDetailsForQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
		return surveyService.retriveQuestion(surveyId, questionId);
	}

	@PostMapping("/Surveys/{surveyId}/Question")
	public ResponseEntity<Object> addQuestionToSurvey(@PathVariable String surveyId, @RequestBody Question question) {

		Question addQuestion = surveyService.addQuestion(surveyId, question);
		if (addQuestion == null)
			return ResponseEntity.noContent().build();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(addQuestion.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
