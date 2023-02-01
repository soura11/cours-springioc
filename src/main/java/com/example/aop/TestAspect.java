package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect // Declare comme bean dans le contexte de l application
@Component
@EnableAspectJAutoProxy // active la configuration des aspects
public class TestAspect {

	// Methode executee au point de jonction
	@Pointcut("execution(public * *..*.*.sayHello())")
	public void log() {
	}

	@Before("log()")
	public void beforAdvice() {
		System.out.println("Befor ..!");
	}

	@After("log()")
	public void afterAdvice() {
		System.out.println("After ..!");
	}

	// around : autour de l’execution de methodes (avant et apres)
	@Around("execution(public * *..*.GreetingService.send(..)) && args(i)")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint, int i) {
		System.out.println("Valeur du parametre dans send() :" + i);
		System.out.println("Signature de la methode : " + proceedingJoinPoint.getSignature());
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Fin de send() avec la valeur de retour : " + value);
		return value;

	}

}
