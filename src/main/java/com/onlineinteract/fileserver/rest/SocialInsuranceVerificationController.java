package com.onlineinteract.fileserver.rest;

import static java.util.regex.Pattern.compile;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlineinteract.fileserver.SocialInsuranceVerificationApp;

@Controller
@EnableAutoConfiguration
public class SocialInsuranceVerificationController {

	private static final Pattern SIN = compile("^\\d\\d\\d-\\d\\d\\d-\\d\\d\\d$");

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "text/plain", value = "/verifySin")
	@ResponseBody
	public ResponseEntity<String> verifySin(@RequestBody Map<String, String> customer) throws SQLException {
		System.out.println("\nVerifying Social Insurance for customer: " + customer);

		String sin = customer.get("SIN");
		PreparedStatement preparedStatement = null;
		preparedStatement = SocialInsuranceVerificationApp.databaseConnection
				.prepareStatement("INSERT INTO sin_verification(sin, verified) VALUES(?, ?)");
		preparedStatement.setQueryTimeout(2);
		preparedStatement.setString(1, sin);
		preparedStatement.setInt(2, 1);
		preparedStatement.executeUpdate();
		preparedStatement.close();

		return new ResponseEntity<>("SIN Verified for customer: " + customer.get("CustomerId"), HttpStatus.OK);
	}

	protected boolean validateSin(String sin) {
		Matcher randomMatcher = SIN.matcher(sin);
		return randomMatcher.matches();
	}
}
