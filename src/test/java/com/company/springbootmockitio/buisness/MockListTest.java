package com.company.springbootmockitio.buisness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class MockListTest {

	public List<String> mockList = mock(List.class);
	
	@Test
	public void size() {
		when(mockList.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mockList.size());
		assertEquals(10, mockList.size());
	}
	
	@Test
	public void returnValue() {
		when(mockList.get(0)).thenReturn("hello");
		assertEquals("hello",mockList.get(0));
		assertEquals(null, mockList.get(1));
	}
	
	@Test
	public void returnGenericParameters() {
		when(mockList.get(anyInt())).thenReturn("hello");
		assertEquals("hello", mockList.get(0));
	}
	
	@Test
	public void verificationBasics() {
		String value1 = mockList.get(0);
		String value2 = mockList.get(1);
		
		verify(mockList).get(0);
		verify(mockList,times(2)).get(anyInt());
		verify(mockList,atLeastOnce()).get(anyInt());
		verify(mockList,atMost(2)).get(anyInt());
		verify(mockList,never()).get(3);
		
	}
	@Test
	public void argumentCapture() {
		
		mockList.add("some argument");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mockList).add(captor.capture());
		assertEquals("some argument",captor.getValue());
	}
	
	@Test
	public void multipleArgumentCapturing() {
		mockList.add("some argument");
		mockList.add("some argument1");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mockList,times(2)).add(captor.capture());
		List<String> ls = captor.getAllValues();
		assertEquals("some argument", ls.get(0));
		assertEquals("some argument1", ls.get(1));
	}
	@Test
	public void mocking() {
		ArrayList arraylistMock = mock(ArrayList.class);
		arraylistMock.add("Test");
		arraylistMock.add("Test2");
		System.out.println(arraylistMock.size());
		when(arraylistMock.size()).thenReturn(5);
		System.out.println(arraylistMock.size());
	}
	@Test
	public void spying() {
		ArrayList arraylistSpy = spy(ArrayList.class);
		System.out.println(arraylistSpy.size());
		arraylistSpy.add("val1");
		arraylistSpy.add("val2");
		arraylistSpy.add("val3");
		System.out.println("spy size "+ arraylistSpy.size());
		when(arraylistSpy.size()).thenReturn(5);
		System.out.println("spy size "+ arraylistSpy.size());
		verify(arraylistSpy).add("val3");
	}
	
	
	
	
}
