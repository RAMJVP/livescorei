package com.liveinfo.livescorei.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;


@Service
public class DateTimeService {

	
	
	public  ZonedDateTime toGmtZonedDateTime(LocalDate localDate) {
        // Convert LocalDate to LocalDateTime at the start of the day
        LocalDateTime localDateTime = localDate.atStartOfDay();
        
        // Convert LocalDateTime to ZonedDateTime in the system default time zone
        ZonedDateTime localZonedDateTime = localDateTime.atZone(ZoneId.systemDefault());

        // Convert ZonedDateTime to GMT
        ZonedDateTime gmtZonedDateTime = localZonedDateTime.withZoneSameInstant(ZoneId.of("GMT"));

        return gmtZonedDateTime;
    }
	
	public  ZonedDateTime toGmtZonedDateTimeEnd(LocalDate localDate) {
        // Convert LocalDate to LocalDateTime at the start of the day
        LocalDateTime localDateTime = localDate.atTime(23, 59, 59);
        
        // Convert LocalDateTime to ZonedDateTime in the system default time zone
        ZonedDateTime localZonedDateTime = localDateTime.atZone(ZoneId.systemDefault());

        // Convert ZonedDateTime to GMT
        ZonedDateTime gmtZonedDateTime = localZonedDateTime.withZoneSameInstant(ZoneId.of("GMT"));

        return gmtZonedDateTime;
    }
}
