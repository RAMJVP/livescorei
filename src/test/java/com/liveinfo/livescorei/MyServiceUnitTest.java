package com.liveinfo.livescorei;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.liveinfo.livescorei.config.LiveInfoConfig;

@ExtendWith(SpringExtension.class)

public class MyServiceUnitTest {
	
	
	@Test
	public void testGMTToDate(){
		System.out.println("test"+LiveInfoConfig.getDate("2024-06-08T14:30:00"));
		
		System.out.println("test1#"+LiveInfoConfig.gmtToIST(LiveInfoConfig.getISTDateTime("2024-06-09T17:00:00")));
		
		System.out.println("test2#"+LiveInfoConfig.gmtToIST(LiveInfoConfig.getISTDateTime("2024-06-09T14:30:00")));
		
		System.out.println("test3#"+LiveInfoConfig.gmtToIST(LiveInfoConfig.getISTDateTime("2024-06-09T00:30:00")));
		
		//System.out.println("test4#"+LiveInfoConfig.gmtToIST(LiveInfoConfig.getISTDateTime("2024-06-07T23:30:00")));
		
		
		
		//"dateTimeGMT": "2024-06-08T14:30:00"
		//LiveInfoConfig.gmtToIST
	}
	
	
	@Test
	public void testCurrTimeStamp(){
		long timestamp = System.currentTimeMillis();
		System.out.println("Current Timestamp: " + timestamp);

		
	}
	
	
    // Test methods
}
