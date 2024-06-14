package com.liveinfo.livescorei.util;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeUtil {

    // Convert LocalDateTime to ZonedDateTime in a specific time zone
    public static ZonedDateTime toZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId) {
        return localDateTime.atZone(zoneId);
    }

    // Compare LocalDateTime and ZonedDateTime
    public static int compareLocalDateTimeAndZonedDateTime(LocalDateTime localDateTime, ZonedDateTime zonedDateTime) {
        // Convert LocalDateTime to the time zone of ZonedDateTime
        ZonedDateTime localDateTimeInZonedDateTimeZone = toZonedDateTime(localDateTime, zonedDateTime.getZone());
        
        // Compare the two ZonedDateTime instances
        return localDateTimeInZonedDateTimeZone.compareTo(zonedDateTime);
    }
    //DateTimeUtil.compareLocalDateTimeAndZonedDateTime(m.getDateTimeGMT(), dateTimeService.toGmtZonedDateTime(LocalDate.now()))>= 0
}
