package com.nt.test;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringI18nTest {

	public static void main(String[] args) {
		// create IOC container

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		// read inputs
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("enter the language code: ");
			String langCode = sc.next();

			System.out.println("ente the Country code: ");
			String countryCode = sc.next();

			// prepared Locale object havaing language and country
			Locale locale = new Locale(langCode, countryCode);

			// get message form locale specific properties file

			String msg = ctx.getMessage("wish.message", new Object[] {}, locale);
			System.out.println("wish message is " + msg);

			// close container
			ctx.close();
		}

	}
}