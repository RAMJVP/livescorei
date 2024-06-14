package com.liveinfo.livescorei;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.liveinfo.livescorei.config.LiveInfoConfig;
import com.liveinfo.livescorei.constant.LiveInfoConstant;

@ExtendWith(SpringExtension.class)

public class MyServiceUnitTest {
	
	
	@Test
	public void testGMTToDate(){
		System.out.println("test"+LiveInfoConfig.getDate("2024-06-08T14:30:00"));
		
		System.out.println("test1#"+LiveInfoConfig.gmtToIST(LiveInfoConfig.getISTDateTime("2024-06-11T14:30:00")));
		
		System.out.println("test2#"+LiveInfoConfig.gmtToIST(LiveInfoConfig.getISTDateTime("2024-06-12T14:30:00")));
		
		System.out.println("test3#"+LiveInfoConfig.gmtToIST(LiveInfoConfig.getISTDateTime("2024-06-12T00:30:00")));
		
		System.out.println("test4#"+LiveInfoConfig.gmtToIST(LiveInfoConfig.getISTDateTime("2024-06-11T23:30:00")));
		
		
		
		//"dateTimeGMT": "2024-06-08T14:30:00"
		//LiveInfoConfig.gmtToIST
	}
	
	
	@Test
	public void testCurrTimeStamp(){
		long timestamp = System.currentTimeMillis();
		System.out.println("Current Timestamp: " + timestamp);

		
	}
	int i=10;
	
	@Test
	public void testCurrTimeStamp1(){
		//long timestamp = System.currentTimeMillis();
		System.out.println("Current Timestamp: " + ++i);

		System.out.println("Current Timestamp: " + ++i);
	}
	
	
	@Test
	public void testAPIKeyServ(){
		//long timestamp = System.currentTimeMillis();
		System.out.println("null?>>>" +  LiveInfoConstant.API_KEYS_MAP.get("123"));

	}
	
	
	
    // Test methods
	//localdate to gmt 
	//2 gmt dataetime comapre
	//generic one
	
	@Test
	public void testDataetimeGMT(){
		System.out.println("null?>>>" );

	}
	
}
