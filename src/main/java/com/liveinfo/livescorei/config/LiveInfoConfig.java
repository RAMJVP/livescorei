package com.liveinfo.livescorei.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.time.ZoneId;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.liveinfo.livescorei.constant.LiveInfoConstant;
import com.liveinfo.livescorei.model.MatchBoard;

@Configuration
public class LiveInfoConfig {

   


	@Bean
    public Map<LocalDate, List<MatchBoard>> cacheMap() {
    	
    	//precompute on
    	 return Map.of(
    			 LocalDate.of(2024, 06, 13),getMatchList(),
    			 LocalDate.of(2024, 06, 14),getMatchList12()
    	            //getDate("a"), getMatchList(),
    	            //getDate("a"), getMatchList()
    	        );
    }
    
    
    
    private static List<MatchBoard> getMatchList12() {

    	return List.of(new MatchBoard.Builder().withId("86dc3169-c2e2-45ef-889f-e3b210d3c1ed")
    			.withT1("Ireland [IRE]").withT2("United States [USA]").withDateTimeGMT("06/14/2024 14:30:00").withTStamp(LiveInfoConstant.CURR_TS).build(),
    			new MatchBoard.Builder().withId("3081e597-a84f-4f85-a05a-02e4ef231e79")
    			.withT1("Afghanistan [AFG]").withT2("Papua New Guinea [PNG]").withDateTimeGMT("06/14/2024 00:30:00").withTStamp(LiveInfoConstant.CURR_TS).build(),
    			new MatchBoard.Builder().withId("37f27c0e-60fa-40eb-812e-e9910f292687")
    			.withT1("England [ENG]").withT2("Oman [OMAN]").withDateTimeGMT("06/13/2024 19:00:00").withTStamp(LiveInfoConstant.CURR_TS).build()
    			);
    }



	public static LocalDate getDate(String gmt) {
    	try {
    		// Given date-time string in ISO format (GMT/UTC+00)
            //String dateTimeString = "2024-06-14T00:30:00";

            // Define the formatter for ISO date-time
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

            // Parse the string to a ZonedDateTime object in UTC
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(gmt, formatter.withZone(ZoneOffset.UTC));

            // Convert the ZonedDateTime to LocalDateTime
            LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
            
            LocalDate localDate = zonedDateTime.toLocalDate();
            System.out.println("Time: " + zonedDateTime.toLocalTime());
            // Print the LocalDateTime
            System.out.println("LocalDateTime: " + localDateTime);
            System.out.println("LocalDate: " + localDate);
            return localDate;
    	}catch(Exception e) {
    		System.err.println("Error occured "+e.getCause());
    	}
    	
    	return LocalDate.now();
    }
    
    
    
    
    
    
    private static List<MatchBoard> getMatchList() {
    	
		/*
		 * 6b41a10b-61c0-4162-afd4-dd07bc84fb13 f5e74e9d-a49f-42a4-8d7e-84d05b837a4f
		 * c99e9832-62a5-495d-b33f-f3a149f9441e
		 */
    	return List.of(new MatchBoard.Builder().withId("29489f2a-f500-4cf9-99d3-74170619a3c4")
    			.withT1("Bangladesh [BAN]").withT2("Netherlands [NED]").withDateTimeGMT("06/13/2024 14:30:00").withTStamp(LiveInfoConstant.CURR_TS).build());
    			//new MatchBoard.Builder().withId("8d740a04-3776-40cc-af7f-3f66b755275e").withT1("Afghanistan [AFG]").withT2("New Zealand [NZ]").build());
    	
    	//8d740a04-3776-40cc-af7f-3f66b755275e	"2024-06-07T23:30:00"	Afghanistan [AFG]	New Zealand [NZ]	
    	
    }
    
    //get 2 methods call
    
    public static LocalDateTime getISTDateTime(String gmt) {
    	try {
    		// Given date-time string in ISO format (GMT/UTC+00)
            //String dateTimeString = "2024-06-14T00:30:00";

            // Define the formatter for ISO date-time
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

            // Parse the string to a ZonedDateTime object in UTC
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(gmt, formatter.withZone(ZoneOffset.UTC));

            // Convert the ZonedDateTime to LocalDateTime
            LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
            
            LocalDate localDate = zonedDateTime.toLocalDate();
           // System.out.println("Time: " + zonedDateTime.toLocalTime());
            // Print the LocalDateTime
           // System.out.println("LocalDateTime: " + localDateTime);
            //System.out.println("LocalDate: " + localDate);
            return localDateTime;
    	}catch(Exception e) {
    		System.err.println("Error occured "+e.getCause());
    	}
    	
    	return LocalDateTime.now();
    }
    
    
    //gmt to newyork & ist time
    public static ZonedDateTime gmtToIST(LocalDateTime gmtTime) {
    	try {
    		
    		
    		 	ZonedDateTime gmtDateTime = gmtTime.atZone(ZoneId.of("GMT"));

    	        ZonedDateTime indiaTime = gmtDateTime.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
    	        //ZonedDateTime newYorkTime = gmtDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
    	       // System.out.println("gmtToIST "+indiaTime);
    		
            return indiaTime;
    	}catch(Exception e) {
    		System.err.println("Error occured "+e.getCause());
    	}
    	
    	return null;
    }
    
    
}

