package com.onlineinteract.fileserver.rest;

import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SocialInsuranceVerificationController {

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "text/plain", value = "/verifySin")
	@ResponseBody
	public ResponseEntity<String> verifySin(@RequestBody Map<String, String> customer) {
		System.out.println("\nVerifying Social Insurance for customer: " + customer);
		
		String sin = customer.get("SIN");
		
		
		return new ResponseEntity<>("SIN Verified for customer: " + customer.get("CustomerId"), HttpStatus.OK);
	}
}
