package com.dongwu.demo.util;

import java.util.Random;

public class Code {

	public String createCode(){
		
		String code = "";
		
		for(int i = 0;i < 6;i++) {
		int ran = new Random().nextInt(10);
		code += ran;
		}
		System.out.println(code);
		
		return code;
	}

}
