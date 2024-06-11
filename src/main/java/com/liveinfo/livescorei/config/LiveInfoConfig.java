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

import com.liveinfo.livescorei.model.MatchBoard;

@Configuration
public class LiveInfoConfig {

    @Bean
    public Map<LocalDate, List<MatchBoard>> cacheMap() {
    	
    	//precompute on
    	 return Map.of(
    			 LocalDate.of(2024, 06, 11),getMatchList(),
    			 LocalDate.of(2024, 06, 12),getMatchList12()
    	            //getDate("a"), getMatchList(),
    	            //getDate("a"), getMatchList()
    	        );
    }
    
    
    
    private static List<MatchBoard> getMatchList12() {

    	return List.of(new MatchBoard.Builder().withId("bad01ba2-e4e4-46fa-8bba-44c706c27c56")
    			.withT1("India [IND]").withT2("United States [USA]").withDateTimeGMT("06/12/2024 14:30:00").withTStamp(1718081656574l).build(),
    			new MatchBoard.Builder().withId("9a734ec9-93ca-4a7f-a3e8-e57f3cc92082")
    			.withT1("Australia [AUS]").withT2("Namibia [NAM]").withDateTimeGMT("06/12/2024 00:30:00").withTStamp(1718081656574l).build(),
    			new MatchBoard.Builder().withId("99430493-10c5-4d91-8af7-f5bf546d22d2")
    			.withT1("Nepal [NEP]").withT2("Sri Lanka [SL]").withDateTimeGMT("06/11/2024 23:30:00").withTStamp(1718081656574l).build()
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
    	return List.of(new MatchBoard.Builder().withId("fac54fb3-4ad5-4e17-aa03-cac77db181fe")
    			.withT1("Canada [CAN]").withT2("Pakistan [PAK]").withDateTimeGMT("06/11/2024 14:30:00").withTStamp(1718081656574l).build());
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
            System.out.println("Time: " + zonedDateTime.toLocalTime());
            // Print the LocalDateTime
            System.out.println("LocalDateTime: " + localDateTime);
            System.out.println("LocalDate: " + localDate);
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
    	        System.out.println("gmtToIST "+indiaTime);
    		
            return indiaTime;
    	}catch(Exception e) {
    		System.err.println("Error occured "+e.getCause());
    	}
    	
    	return null;
    }
    
    
}

