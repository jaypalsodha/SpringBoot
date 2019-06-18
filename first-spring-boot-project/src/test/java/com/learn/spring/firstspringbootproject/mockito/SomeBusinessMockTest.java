package com.learn.spring.firstspringbootproject.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;

public class SomeBusinessMockTest {

	@Test
	public void testfindTheGreatestOfAll() {
		DataService dataService = mock(DataService.class);
		when(dataService.retriveAllData()).thenReturn(new int[] {24,15,6});
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataService);
		int result = businessImpl.findTheGreatestOfAll();
		assertEquals(24,result);
	}
	@Test
	public void testfindTheGreatestOfAll_forOneValue() {
		DataService dataService = mock(DataService.class);
		when(dataService.retriveAllData()).thenReturn(new int[] {1});
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataService);
		int result = businessImpl.findTheGreatestOfAll();
		assertEquals(1,result);
	}
}

