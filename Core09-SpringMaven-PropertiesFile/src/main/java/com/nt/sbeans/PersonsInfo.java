package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("per") // cfg of java class as spring bean
@PropertySource("com/nt/commons/info.properties") // cfgs of properties file
public class PersonsInfo {

	@Value("${per.name}")
	private String pname;
	
	@Value("${per.addr}")
	private String paddr;

	@Value("${per.age}")
	private int page;

	@Override
	public String toString() {
		return "PersonsInfo [pname=" + pname + ", paddr=" + paddr + ", page=" + page + "]";
	}
	
	

}
