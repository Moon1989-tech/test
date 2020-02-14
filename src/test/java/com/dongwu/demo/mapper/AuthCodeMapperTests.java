package com.dongwu.demo.mapper;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dongwu.demo.entity.AuthCode;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthCodeMapperTests {
	
	@Autowired
	private AuthCodeMapper mapper;
	
	@Test
	public void insert(){
		AuthCode code = new AuthCode();
		code.setCode("123456");
		code.setPhone("15710326542");
		Date now = new Date();
		code.setCreatedTime(now);
		Integer rows = mapper.insert(code);
		System.err.println(rows);
		
	}
	
	@Test
	public void update() {
		AuthCode code = new AuthCode();
		code.setCode("529687");
		code.setPhone("15710322670");
		code.setTimes(1);
		Integer rows = mapper.updateTimes(code);
		System.err.println(rows);
	}
	
	@Test
	public void delete() {
		mapper.clearDatabase();
	}
	
	

}









