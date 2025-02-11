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
		//gmt correct it , again21,22,23
    	 return Map.of(
    			 LocalDate.of(2024, 02, 11),getMatchList11(),
    			 LocalDate.of(2024, 02, 12),getMatchList12()
    			// LocalDate.of(2024, 06, 26),getMatchList26(),
    			 //LocalDate.of(2024, 06, 25),getMatchList25(),
    			 //LocalDate.of(2024, 06, 24),getMatchList24()
    	            //getDate("a"), getMatchList(),
    	            //getDate("a"), getMatchList()
    	        );
    }
    
    
	
	  private static List<MatchBoard> getMatchList24() {

	    	return List.of(new MatchBoard.Builder().withId("44b16720-8b94-48c5-b865-502af6ba671d")
	    			.withT1("Australia [AUS]").withT2("India [IND]").withDateTimeGMT("06/24/2024 14:30:00").withTStamp(LiveInfoConstant.CURR_TS).build()
	    			);
	    }
	  
	  
	  private static List<MatchBoard> getMatchList25() {

	    	return List.of(new MatchBoard.Builder().withId("b07109a0-4a66-44e7-ac74-7d931b9b9ca5")
	    			.withT1("Afghanistan [AFG]").withT2("Bangladesh [BAN]").withDateTimeGMT("6/25/2024 00:30:00").withTStamp(LiveInfoConstant.CURR_TS).build()
	    			);
	    }
	  
    
    private static List<MatchBoard> getMatchList11() {
    
    	return List.of(
    			new MatchBoard.Builder().withId("87abc39a-bff8-4891-ad56-05dc19d2b0ec")
    			.withT1("India").withT2("England").withDateTimeGMT("02/11/2025 14:30:00").withTStamp(LiveInfoConstant.CURR_TS).build()
    			);
    }

    
   

    
    private static List<MatchBoard> getMatchList12() {

    	return List.of(
    			new MatchBoard.Builder().withId("87abc39a-bff8-4891-ad56-05dc19d2b0ec")
    			.withT1("England [ENG]").withT2("India [IND]").withDateTimeGMT("02/12/2025 14:30:00").withTStamp(LiveInfoConstant.CURR_TS).build()
    			);
    }
    
    
    
    private static List<MatchBoard> getMatchList26() {

    	return List.of(
    			
    			new MatchBoard.Builder().withId("48bdfae7-79af-4991-9453-a0f4722b003b")
    			.withT1( "USA ").withT2("England").withDateTimeGMT("06/23/2024 14:30:00").withTStamp(LiveInfoConstant.CURR_TS).build(),
    			new MatchBoard.Builder().withId("1")
    			.withT1("Afghanistan").withT2( "Australia").withDateTimeGMT("06/23/2024 06:30:00").withTStamp(LiveInfoConstant.CURR_TS).build()
    			
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

