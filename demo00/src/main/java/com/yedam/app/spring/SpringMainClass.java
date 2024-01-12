package com.yedam.app.spring;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		System.out.println("Spring 방식");
	ApplicationContext
	ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
	
	TV tv = (TV)ctx.getBean(TV.class);
	//TV tv = (TV)ctx.getBean("tv");
	tv.on();
	}

}
