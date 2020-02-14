package com.dongwu.demo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongwu.demo.entity.AuthCode;
import com.dongwu.demo.mapper.AuthCodeMapper;
import com.dongwu.demo.service.IAuthCodeService;
import com.dongwu.demo.service.ex.CodeNotMatchException;
import com.dongwu.demo.service.ex.InsertException;
import com.dongwu.demo.service.ex.OvertimeException;
import com.dongwu.demo.service.ex.OveruseException;
import com.dongwu.demo.service.ex.PhoneNotFoundException;
import com.dongwu.demo.service.ex.TimeTooShortException;
import com.dongwu.demo.service.ex.TooManyCodeException;
import com.dongwu.demo.util.Code;

@Service
public class AuthCodeServiceImpl implements IAuthCodeService {

	@Autowired
	private AuthCodeMapper authCodeMapper;

	@Override
	public void CreateCode(AuthCode authCode) {
		AuthCode result = authCodeMapper.findByPhone(authCode.getPhone());
		Date now = new Date();
		String code = new Code().createCode();
		// 判断该手机号码是否获取过验证码
		if (result == null) {
			authCode.setCode(code);
			authCode.setCount(1);
			authCode.setCreatedTime(now);
			Integer rows = authCodeMapper.insert(authCode);
			// 判断是否插入成功:rows是否不为1
			if (rows != 1) {
				// 是:表示注册失败,则抛出InsertException
				throw new InsertException("获取验证码时出现未知错误,请联系系统管理员");
			}
			return;
		}

		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		boolean isSameDay = sd.format(now).equals(sd.format(result.getCreatedTime()));

		// 判断该号码一天内获取验证码次数是否超过20次
		if (result.getCount() >= 20 && isSameDay) {
			throw new TooManyCodeException("今天获取验证码的次数超过了20次");
		}
		// 两条验证码之间的时间间隔
		long nowTime = now.getTime();
		long lastTime = result.getCreatedTime().getTime();
		long time = nowTime - lastTime;

		// 两条验证码之间的间隔是否不大于分钟
		if (time < 1 * 60 * 1000) {
			throw new TimeTooShortException("获取验证码过于频繁");
		}

		if (!isSameDay) {
			authCode.setCount(1);
		} else {
			authCode.setCount(result.getCount() + 1);
		}

		// 符合以上两个要求后补充数据
		authCode.setCode(code);
		authCode.setCreatedTime(now);
		// 调用mapper,存储数据
		Integer rows = authCodeMapper.insert(authCode);
		// 判断是否插入成功:rows是否不为1
		if (rows != 1) {
			// 是:表示注册失败,则抛出InsertException
			throw new InsertException("获取验证码时出现未知错误,请联系系统管理员");
		}

	}

	@Override
	public void CheckAuthCode(String phone, String code) {
		AuthCode result = authCodeMapper.findByPhone(phone);
		// 判断该号码是否获取过验证码
		if (result == null) {
			throw new PhoneNotFoundException("请先获取验证码");
		}

		Date now = new Date();
		long difftime = now.getTime() - result.getCreatedTime().getTime();
		// 验证码有效期为5分钟,判断是否超过分钟
		if (difftime > 5 * 60 * 1000) {
			// 超过5分钟验证码失效
			throw new OvertimeException("您使用的验证码已经超时,请重新获取");
		}

		// 验证码三次有效,判断是否超过三次
		if (result.getTimes() >= 3) {
			throw new OveruseException("您的验证使用次数已经超过三次,请重新获取");
		}
		// 比对输入验证码和获取到的验证码是否一致
		if (!result.getCode().equals(code)) {
			throw new CodeNotMatchException("您输入的验证码有误!");
		}

		// 验证成功,验证码使用次数加1
		AuthCode authCode = new AuthCode();
		authCode.setCode(code);
		authCode.setPhone(phone);
		authCode.setTimes(result.getTimes() + 1);

		Integer rows = authCodeMapper.updateTimes(authCode);

		// 判断是否插入成功:rows是否不为1
		if (rows != 1) {
			// 是:验证失败,则抛出InsertException
			throw new InsertException("验证验证码时出现未知错误,请联系系统管理员");
		}

	}

	@Override
	public void clearDatabase() {
		System.err.println("执行了clearDatabase()");
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
			authCodeMapper.clearDatabase();
			}
		}, 24*60*60*1000);
		System.err.println("clearDatabase()执行完了");
	}

}
