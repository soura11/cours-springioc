package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.repository.MyRepository;

@Component
public class MyComponent {

	@Autowired
	private MyRepository myRepository;

	public MyComponent() {

	}

	public void showAppInfo() {
		System.out.println("la date est de : " + myRepository.getDateTime());
		System.out.println("le nom du projet est : " + myRepository.getAppName());
	}

}
