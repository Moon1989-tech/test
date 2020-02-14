package com.dongwu.demo.service;

import com.dongwu.demo.entity.AuthCode;

public interface IAuthCodeService {
	
	/**
	 * 生成验证码
	 * @param authCode 生成的验证码对象
	 */
	void CreateCode(AuthCode authCode);
	
	/**
	 * 检验输入的验证过你吗是否正确
	 * @param phone 校验的手机号码
	 * @param code	用户输入的验证码
	 */
	void CheckAuthCode(String phone,String code);
	
	/**
	 * 定期清理无用验证码
	 */
	void clearDatabase();
	
	

}















