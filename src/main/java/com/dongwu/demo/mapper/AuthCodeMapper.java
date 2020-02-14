package com.dongwu.demo.mapper;

import java.util.Date;

import com.dongwu.demo.entity.AuthCode;

public interface AuthCodeMapper {
	
	/**
	 * 存储验证码
	 * @param authCode 增加的验证码对象
	 * @return 受影响行数
	 */
	Integer insert(AuthCode authCode);
	
	/**
	 * 查询验证码
	 * @param phone 要查找的手机号
	 * @return 查询到的结果
	 */
	AuthCode findByPhone(String phone);
	
	/**
	 * 更改验证码的使用次数
	 * @param authCode 要更改的验证码对象
	 * @return 受影响的行数
	 */
	Integer updateTimes(AuthCode authCode);
	
	/**
	 * 定时清理无用的验证码
	 * @param createdTime 需要清除数据的截止日期
	 */
	void clearDatabase();

}
