package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Injecter un bean de type service ds la factory de spring core
public class GreetingService {
	
	//Recupere un bean injecte avec Autowired ds la class AppConfig
	@Autowired
	private Language language;

	public GreetingService() {
		// TODO Auto-generated constructor stub
	}
	
	public void sayHello() {
		System.out.println("Message : " + language.getHello());
	}

}
