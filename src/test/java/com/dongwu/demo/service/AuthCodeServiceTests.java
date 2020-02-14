package com.dongwu.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dongwu.demo.entity.AuthCode;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthCodeServiceTests {
	
	@Autowired
	private IAuthCodeService service;
	
	@Test
	public void createCode() {
		AuthCode authCode = new AuthCode();
		authCode.setPhone("15710322670");
		
		service.CreateCode(authCode);
		System.err.println("OK.");
		
	}
	
	@Test
	public void checkCode() {
		String phone = "15710322670";
		String code = "207970";
		
		service.CheckAuthCode(phone, code);
		System.err.println("OK.");
	}
	
	@Test
	public void clearDatabase() {
		service.clearDatabase();
	}

}





















