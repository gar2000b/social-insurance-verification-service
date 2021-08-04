package com.onlineinteract.fileserver.rest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class SocialInsuranceVerificationControllerTest {

	private static SocialInsuranceVerificationController socialInsuranceVerificationController;

	@BeforeClass
	public static void setup() {
		socialInsuranceVerificationController = new SocialInsuranceVerificationController();
	}

	@Test
	public void verifySinTest() {
		boolean result = socialInsuranceVerificationController.validateSin("123-456-789");
		assertEquals(true, result);
	}
	
	@Test
	public void verifySinFailTest() {
		boolean result = socialInsuranceVerificationController.validateSin("1234-456-789");
		assertEquals(false, result);
	}

}
