package com.nt.aspect;

import java.io.FileWriter;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.nt.exception.InvalidInputsException;

@Component("expLogger")
@Aspect
public class CommonExceptionLogger_Grapher {

	@AfterThrowing(value="execution(double com.nt.service.ShoppingStore.generateBill(..))",throwing="e")
	public void exceptionLoggingAndGraphing(JoinPoint jp,Exception e)throws Exception{
		System.out.println("CommonExceptionLogger_Grapher.exceptionLoggingAndGraphing()");
		
		//common exception logger
		String logMsg=e + "exception raised in "+jp.getSignature()+" with args" +Arrays.deepToString(jp.getArgs());
		
		FileWriter writer=new FileWriter("F:\\expLog.txt",true);
		writer.write(logMsg+"\n");
		writer.flush();
		writer.close();
		
		//Common Exception Grapher(Converting original raised Exception to another project specific user-defined exception
		throw new InvalidInputsException(e.getMessage());
	}
}

