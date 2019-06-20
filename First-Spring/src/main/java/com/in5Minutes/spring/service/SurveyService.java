package com.in5Minutes.spring.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in5Minutes.spring.model.Question;
import com.in5Minutes.spring.model.Survey;

@Component
public class SurveyService {

	private static List<Survey> surveys = new ArrayList<Survey>();
	
	static {
		List<String> asList = Arrays.asList("India","China","Pakistan","Russia");
		Question q1 = new Question("1", "Largest conuntry in the world?",
				"Russia", asList);
		Question q2 = new Question("2", "Most popular conutry in the world?",
				"India", asList);
		Question q3 = new Question("3", "Highest Gdp in the world?",
				"China", asList);
		
		List<Question> questions = new ArrayList<>(Arrays.asList(q1,q2,q3));
		
		Survey survey = new Survey("1", "My Favorite Survey", "Description of survey",
				questions);
		surveys.add(survey);
	}
	public List<Survey> retriveAllSurveys(){
		return surveys;
	}
	public Survey retriveSurvey(String surveyId) {
		for (Survey survey : surveys) {
			if(survey.getId().equals(surveyId))
				return survey;
		}
		return null;
	}
	public List<Question> retriveQuestions(String surveyId){
		Survey survey = retriveSurvey(surveyId);
		if(survey == null) {
			return null;
		}
		return survey.getQuestions();
	}
	public Question retriveQuestion(String surveyId, String questionId) {
		Survey survey = retriveSurvey(surveyId);
		if(survey == null) {
			return null;
		}
		for (Question question : survey.getQuestions()) {
			if(question.getId().equals(questionId)) {
				return question;
			}
		}
		return null;
	}
	private SecureRandom random = new SecureRandom();
	
	public Question addQuestion(String surveyId, Question question) {
		Survey survey = retriveSurvey(surveyId);
		if(survey == null) {
			return null;
		}
		String randonId = new BigInteger(130,random).toString(32);
		question.setId(randonId);
		survey.getQuestions().add(question);
		return question;
	}
}
