package com.dongwu.demo.entity;

import java.util.Date;

public class AuthCode {
	private int id;
	private String phone;
	private String code;
	private Date createdTime;
	private int count;
	private int times;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "AuthCode [id=" + id + ", phone=" + phone + ", code=" + code + ", createdTime=" + createdTime
				+ ", count=" + count + ", times=" + times + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthCode other = (AuthCode) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
