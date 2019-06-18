package com.learn.spring.firstspringbootproject.mockito;

public class SomeBusinessImpl {

	DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}
	public int findTheGreatestOfAll() {
		int[] data = dataService.retriveAllData();
		int gretest = Integer.MIN_VALUE;
		for (int value : data) {
			if (value > gretest)
				gretest = value;
		}
		return gretest;
	}
}
