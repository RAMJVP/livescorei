package com.liveinfo.livescorei;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)

public class MyServiceUnitTest2 {
	
	
	@Test
	public void testGMTToDate(){
		
		ZonedDateTime zonedDateTime=toGmtZonedDateTime(LocalDate.now());
		
		System.out.println("ZonedDateTime##"+zonedDateTime);
		
		LocalDateTime localDateTime=strToGmT();
		System.out.println("LocalDateTime##"+localDateTime);
		
		
		
		 int comparisonResult = DateTimeUtil.compareLocalDateTimeAndZonedDateTime(localDateTime, zonedDateTime);

	        if (comparisonResult < 0) {
	            System.out.println("LocalDateTime is before ZonedDateTime");
	        } else if (comparisonResult > 0) {
	            System.out.println("LocalDateTime is after ZonedDateTime");
	        } else {
	            System.out.println("LocalDateTime is equal to ZonedDateTime");
	        }
	        
	        
	        
	        
		
		
		//"dateTimeGMT": "2024-06-08T14:30:00"
		//LiveInfoConfig.gmtToIST
	}
	
	
	public static ZonedDateTime toGmtZonedDateTime(LocalDate localDate) {
        // Convert LocalDate to LocalDateTime at the start of the day
        LocalDateTime localDateTime = localDate.atStartOfDay();
        
        // Convert LocalDateTime to ZonedDateTime in the system default time zone
        ZonedDateTime localZonedDateTime = localDateTime.atZone(ZoneId.systemDefault());

        // Convert ZonedDateTime to GMT
        ZonedDateTime gmtZonedDateTime = localZonedDateTime.withZoneSameInstant(ZoneId.of("GMT"));

        return gmtZonedDateTime;
    }
	
	
	
	 static LocalDateTime strToGmT(){
		//efine the date-time string
        String dateTimeString = "2024-06-12T18:30Z";
        
        // Parse the string to a ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTimeString, DateTimeFormatter.ISO_ZONED_DATE_TIME);

        // Convert to LocalDateTime
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();

        // Print the results
        //System.out.println("ZonedDateTime: " + zonedDateTime);
        //System.out.println("LocalDateTime: " + localDateTime);
        return localDateTime;
	}
	 
	 
	 public static int compareGmtZonedDateTimes(ZonedDateTime zdt1, ZonedDateTime zdt2) {
	        return zdt1.compareTo(zdt2);
	    }
	 
	 
	 
	
}
