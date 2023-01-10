package com.example.repository;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {

	public String getAppName() {
		return "Hello spring ioc";
	}

	public Date getDateTime() {
		return new Date();
	}
}
