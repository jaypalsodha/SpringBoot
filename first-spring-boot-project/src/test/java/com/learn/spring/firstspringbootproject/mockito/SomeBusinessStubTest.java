package com.learn.spring.firstspringbootproject.mockito;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SomeBusinessStubTest {

	@Test
	public void testfindTheGreatestOfAll() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStub());
		int result = businessImpl.findTheGreatestOfAll();
		assertEquals(24,result);
	}
}

class DataServiceStub implements DataService{

	@Override
	public int[] retriveAllData() {
		return new int [] {24,6,11};
	}
}
