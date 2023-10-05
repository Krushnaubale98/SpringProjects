package com.nt.aspect;

import java.util.Scanner;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("testDrive")
@Aspect
public class TestDriveBeforeAdvice {

	@Before(value = "execution(java.lang.String com.nt.service.CarShowRoom.purchase(..))")
	public void testDrive(JoinPoint jp) throws Throwable {
		System.out.println("TestDriveBeforeAdvice.testDrive()");
		Object args[] = jp.getArgs();
		System.out.println(args[0] + " model car test driving is happening....with price " + args[1]);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Did you like car(true/false)?");
		boolean isLiked = sc.nextBoolean();
		if (!isLiked) {
			throw new IllegalArgumentException(args[0] + " is not liked in testing drving");

		}
	}
}
