package com.candidjava.mockito.bl;


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

public class ListMockTest 
{

	List<String> al = mock(List.class);

	@Test
	public void size_basic() 
	{
		al.add("as");
	
		when(al.size()).thenReturn(5);
		when(al.get(0)).thenReturn("as");
		
		assertEquals(5, al.size());  // true
		assertEquals("as", al.get(0)); // true
	}

	@Test
	public void returnDifferentValues() {
		when(al.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, al.size());
		assertEquals(10, al.size());
	}


	
	@Test
	//@Disabled
	public void returnWithParameters() {
		when(al.get(0)).thenReturn("as");
		assertEquals("as", al.get(0));
		assertEquals(null, al.get(1));
	}
		
	@Test
	public void returnWithGenericParameters() {
		when(al.get(anyInt())).thenReturn("aaa");
		assertEquals("aaa", al.get(0));
		assertEquals("aaa", al.get(1));
	}
	

	@Test
	public void verificationBasics() {
		// SUT
		String value1 = al.get(0);
		String value2 = al.get(1);
		//String value5 = mock.get(5);

		// Verify
		verify(al).get(0);
		verify(al, times(2)).get(anyInt());
		verify(al, atLeast(1)).get(anyInt());
		verify(al, atLeastOnce()).get(anyInt());
		verify(al, atMost(2)).get(anyInt());
		verify(al, never()).get(2);
	}
	
	
	@Test
	public void argumentCapturing() {
		//SUT
		al.add("SomeString");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(al).add(captor.capture());
		
		assertEquals("SomeString", captor.getValue());
	}

	@Test
	public void multipleArgumentCapturing() {
		
		//SUT
		al.add("SomeString1");
		al.add("SomeString2");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		verify(al, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));
		
	}
	
	@Test
	public void mocking() {
		ArrayList arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//0
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());//5
	}

	@Test
	public void spying() {
		
		ArrayList arrayListSpy = spy(ArrayList.class);
		
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));//Test0
		System.out.println(arrayListSpy.size());//1

		arrayListSpy.add("Test1");
		arrayListSpy.add("Test2");
		
		System.out.println(arrayListSpy.size());//3
		
		when(arrayListSpy.size()).thenReturn(5);
		
		System.out.println(arrayListSpy.size()); //5
		
		assertEquals("Test0", arrayListSpy.get(0));
		
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size());//5
		
		verify(arrayListSpy).add("Test4");
	}
}
