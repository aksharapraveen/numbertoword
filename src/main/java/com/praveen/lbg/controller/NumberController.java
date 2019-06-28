package com.praveen.lbg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.lbg.service.NumberToWordConverterUtilImpl;

@RestController
public class NumberController {

	private static final Logger log = LoggerFactory.getLogger(NumberController.class);

	@Autowired
	NumberToWordConverterUtilImpl numberToWordConverterUtilImpl;

	@GetMapping("number/{number}")
	public String index(@PathVariable(value = "number") Long number) {
		log.info("Enter into thenumber /number {}",number);
		return numberToWordConverterUtilImpl.convertToWords(number);
	}

}
