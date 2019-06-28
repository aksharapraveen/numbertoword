package com.praveen.lbg.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.praveen.error.ExceptionResponse;
import com.praveen.error.NumberNotFoundException;

@Service
public class NumberToWordConverterUtilImpl {

	private static final Logger log = LoggerFactory.getLogger(NumberToWordConverterUtilImpl.class);

	private HashMap<Long, String> unitMapper = new HashMap<Long, String>();
	private ArrayList<Long> numberUnit = new ArrayList<Long>();

	public NumberToWordConverterUtilImpl() {
		super();
		assignUnitMapper();
	}

	private void assignNumberUnit() {
		numberUnit.add(1L);
		numberUnit.add(2L);
		numberUnit.add(3L);
		numberUnit.add(4L);
		numberUnit.add(5L);
		numberUnit.add(6L);
		numberUnit.add(7L);
		numberUnit.add(8L);
		numberUnit.add(9L);
		numberUnit.add(10L);
		numberUnit.add(11L);
		numberUnit.add(12L);
		numberUnit.add(13L);
		numberUnit.add(14L);
		numberUnit.add(15L);
		numberUnit.add(16L);
		numberUnit.add(17L);
		numberUnit.add(18L);
		numberUnit.add(19L);

		numberUnit.add(20L);
		numberUnit.add(30L);
		numberUnit.add(40L);
		numberUnit.add(50L);
		numberUnit.add(60L);
		numberUnit.add(70L);
		numberUnit.add(80L);
		numberUnit.add(90L);

		numberUnit.add(100L);
		numberUnit.add(1000L);
		numberUnit.add(1000000L);
		numberUnit.add(1000000000L);
	}

	private void assignUnitMapper() {
		unitMapper.put(1L, "One");
		unitMapper.put(2L, "Two");
		unitMapper.put(3L, "Three");
		unitMapper.put(4L, "Four");
		unitMapper.put(5L, "Five");
		unitMapper.put(6L, "Six");
		unitMapper.put(7L, "Seven");
		unitMapper.put(8L, "Eight");
		unitMapper.put(9L, "Nine");
		unitMapper.put(10L, "Ten");
		unitMapper.put(11L, "Eleven");
		unitMapper.put(12L, "Twelve");
		unitMapper.put(13L, "Thirteen");
		unitMapper.put(14L, "Fourteen");
		unitMapper.put(15L, "Fifteen");
		unitMapper.put(16L, "Sixteen");
		unitMapper.put(17L, "Seventeen");
		unitMapper.put(18L, "Eighteen");
		unitMapper.put(19L, "Nineteen");
		unitMapper.put(20L, "Twenty");
		unitMapper.put(30L, "Thirty");
		unitMapper.put(40L, "Fourty");
		unitMapper.put(50L, "Fifty");
		unitMapper.put(60L, "Sixty");
		unitMapper.put(70L, "Seventy");
		unitMapper.put(80L, "Eighty");
		unitMapper.put(90L, "Ninety");
		unitMapper.put(100L, "Hundred");
		unitMapper.put(1000L, "Thousand");
		unitMapper.put(1000000L, "Million");
		unitMapper.put(1000000000L, "Billion");

		assignNumberUnit();
	}

	public String convertToWords(Long number) {
		log.info("Enter into the convertToWords of number: {}", number);
		String inWords = "";
		try {
			if (0 == number)
				return "Zero";

			if (number <= 19)
				return unitMapper.get(number);

			for (int i = numberUnit.size() - 1; i > 18; i--) {
				if ((number / numberUnit.get(i)) >= 1) {
					if (number > 99) {
						inWords += convertToWords(number / numberUnit.get(i)) + " " + unitMapper.get(numberUnit.get(i))
								+ " ";
					} else {
						inWords += unitMapper.get(numberUnit.get(i)) + " ";
					}
					number = number % numberUnit.get(i);
					if (number == 0) {
						break;
					}
					inWords += " " + convertToWords(number);
					break;
				}
			}
		}

		catch (NumberNotFoundException e) {
			throw new ExceptionResponse(HttpStatus.NOT_FOUND.value(), "Number Format Issue",
					"Number Format Issue: " + number, e);
		} catch (NullPointerException e) {
			throw new ExceptionResponse(HttpStatus.NOT_FOUND.value(), "Number Format Issue",
					"Number Format Issue: " + number, e);
		} catch (Exception e) {
			throw new ExceptionResponse(HttpStatus.NOT_FOUND.value(), "Number Format Issue",
					"Number Format Issue: " + number, e);
		}
		return inWords;
	}
}
