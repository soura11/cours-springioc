package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.models.User;
import com.example.services.French;
import com.example.services.Language;

//permet de declarer un composant configurant le contexte de l application
@Configuration
@ComponentScan({ "com.example.*" })
public class AppConfig {

	// Un bean est un objet qui est instancie, assemble et gere par la factory de
	// Spring Core
	@Bean(name = "user1")
	public User user1() {
		return new User(2, "Doe", "John", 2500);
	}

	@Bean(name = "language")
	public Language getLanguage() {
		return new French();
	}

}
