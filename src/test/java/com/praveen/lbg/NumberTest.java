package com.praveen.lbg;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.praveen.lbg.service.NumberToWordConverterUtilImpl;

@RunWith(MockitoJUnitRunner.class)
public class NumberTest {

	@InjectMocks
	private final NumberToWordConverterUtilImpl numberToWordConverterUtilImpl = new NumberToWordConverterUtilImpl();

	@Test
	public void numberToText() {
		String one = numberToWordConverterUtilImpl.convertToWords(1L);
		System.out.println("res=" + one);
		assertEquals("One", one);
	}

}
