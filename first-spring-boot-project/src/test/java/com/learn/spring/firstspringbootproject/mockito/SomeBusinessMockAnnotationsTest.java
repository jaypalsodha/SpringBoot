package com.learn.spring.firstspringbootproject.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockAnnotationsTest {

	@Mock
	DataService dataService;
	
	@InjectMocks
	SomeBusinessImpl businessImpl;
	
	@Test
	public void testfindTheGreatestOfAll() {
		when(dataService.retriveAllData()).thenReturn(new int[] {24,11,12});
		assertEquals(24,businessImpl.findTheGreatestOfAll());
	}
	@Test
	public void testfindTheGreatestOfAll_forOneValue() {
		when(dataService.retriveAllData()).thenReturn(new int[] {1});
		assertEquals(1,businessImpl.findTheGreatestOfAll());
	}
}

