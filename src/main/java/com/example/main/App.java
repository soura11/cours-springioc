package com.example.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.config.AppConfig;
import com.example.config.MyComponent;
import com.example.models.User;
import com.example.services.GreetingService;
import com.example.services.Language;

public class App {
	public static void main(String[] args) {
		// Ici on charge le contexte de l application via le fichier xml
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		User u1 = context.getBean("user", User.class);
		System.out.println(u1);

		// Ici on charge le contexte de l application cia la classe AppConfig annote par
		// Configuration
		AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
		User u2 = context2.getBean("user1", User.class);
		System.out.println(u2);

		Language l1 = (Language) context2.getBean("language");
		System.out.println("language : " + l1.getBye());

		System.out.println("-------------");

		GreetingService greetingService = (GreetingService) context2.getBean("greetingService");
		greetingService.sayHello();

		System.out.println("-------------");

		MyComponent component = context2.getBean("myComponent", MyComponent.class);
		component.showAppInfo();
	}
}
