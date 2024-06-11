package com.liveinfo.livescorei.constant;

import java.time.LocalTime;

public class LiveInfoConstant {

	private LiveInfoConstant() {
	}

	public static String lapikey = "1276331d";
	public static int T20_hours = 3;
	public static int innings_MIN = 90;
	public static int break_MIN = 90;
	/*
	 * private static final LocalTime TIME_20_00 = LocalTime.of(20, 00);//17-20
	 * private static final LocalTime TIME_6_00_AM = LocalTime.of(06,
	 * 00);//14:30-17:30 private static final LocalTime TIME_5_00_AM =
	 * LocalTime.of(05, 00);//00:30-03:30 //00:30-03:30 //14:30-20
	 * 
	 * 
	 * //5-9am //20-23:59
	 * 
	 * public static final LocalTime TIME_23_59 = LocalTime.of(23, 59);//17-20
	 * 
	 * 
	 * public static List<LocalTime> times =
	 * List.of(TIME_5_00_AM,TIME_6_00_AM,TIME_20_00);
	 */
	
	//9 JUN prop file change flag service too corn
	public static final LocalTime TIME_S1 = LocalTime.of(6, 00);//17-20
	public static final LocalTime TIME_E1 = LocalTime.of(9, 00);//14:30-17:30
	public static final LocalTime TIME_S2 = LocalTime.of(20, 00);//00:30-03:30
	public static final LocalTime TIME_E2 = LocalTime.of(23, 59);//17-20
	
	
	
	

}
