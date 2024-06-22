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
    			 LocalDate.of(2024, 06, 21),getMatchList21(),
    			 LocalDate.of(2024, 06, 22),getMatchList22(),
    			 LocalDate.of(2024, 06, 23),getMatchList23(),
    			 LocalDate.of(2024, 06, 19),getMatchList19(),
    			 LocalDate.of(2024, 06, 20),getMatchList20()
    	            //getDate("a"), getMatchList(),
    	            //getDate("a"), getMatchList()
    	        );
    }
    
    
	
	  private static List<MatchBoard> getMatchList20() {

	    	return List.of(new MatchBoard.Builder().withId("6a636247-1db3-4e66-8b8d-7338bd4b7dd0")
	    			.withT1("England [ENG]").withT2("West Indies [WI]").withDateTimeGMT("06/20/2024 00:30:00").withTStamp(LiveInfoConstant.CURR_TS).build()
	    		
	    			);
	    }
	  
	  
	  private static List<MatchBoard> getMatchList19() {

	    	return List.of(new MatchBoard.Builder().withId("ead7b255-3c70-4d02-9605-1751a8e1ab6c")
	    			.withT1("South Africa [RSA]").withT2("United States [USA]").withDateTimeGMT("6/19/2024 14:30:00").withTStamp(LiveInfoConstant.CURR_TS).build()
	    			);
	    }
	  
    
    private static List<MatchBoard> getMatchList21() {

    	return List.of(
    			new MatchBoard.Builder().withId("abf0116c-46d5-438e-808a-53fcc856bf19")
    			.withT1("England ").withT2("South Africa").withDateTimeGMT("06/21/2024 14:30:00").withTStamp(LiveInfoConstant.CURR_TS).build()
    			);
    }

    
   

    
    private static List<MatchBoard> getMatchList22() {

    	return List.of(
    			new MatchBoard.Builder().withId("f46388e3-4537-403f-ac25-03d032f1a66d")
    			.withT1("Bangladesh [BAN]").withT2("India [IND]").withDateTimeGMT("06/22/2024 14:30:00").withTStamp(LiveInfoConstant.CURR_TS).build(),
    			new MatchBoard.Builder().withId("87b45baa-7ec8-437e-ab03-bb0dbe6e1cc7")
    			.withT1("United States [USA]").withT2("West Indies [WI]").withDateTimeGMT("06/22/2024 00:30:00").withTStamp(LiveInfoConstant.CURR_TS).build()
    			);
    }
    
    
    
    private static List<MatchBoard> getMatchList23() {

    	return List.of(
    			
    			new MatchBoard.Builder().withId("2")
    			.withT1( "USA ").withT2("England").withDateTimeGMT("06/23/2024 08:30:00").withTStamp(LiveInfoConstant.CURR_TS).build(),
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

