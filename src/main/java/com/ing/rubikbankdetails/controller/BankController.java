package com.ing.rubikbankdetails.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.rubikbankdetails.dto.BankDto;
import com.ing.rubikbankdetails.servcie.BankServcie;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class BankController {
	public static final Logger logger = LoggerFactory.getLogger(BankController.class);

	@Autowired
	BankServcie bankService;

	@GetMapping("/bankDetails/{bankCode}")
	public ResponseEntity<BankDto> bankDetails(@PathVariable String bankCode) {
		logger.info("Enter into the bank controller class");
		return new ResponseEntity<>(bankService.getBankDetails(bankCode), HttpStatus.OK);
	}

}
