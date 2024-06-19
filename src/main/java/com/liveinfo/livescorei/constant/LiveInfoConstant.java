package com.liveinfo.livescorei.constant;

import java.time.LocalTime;
import java.util.Map;

public class LiveInfoConstant {

	private LiveInfoConstant() {
	}

	public static String lapikey = "1276331d";
	public static final long CURR_TS = 1718799675371l;
	public static int T20_hours = 3;
	public static int innings_MIN = 90;
	public static int break_MIN = 90;
	public static String API_KEY ="1276331d-5e40-48e0-9a02-e7035489c3e6";
	
	public static Map<String, String> API_KEYS_MAP = Map.of(
            "1276331d-5e40-48e0-9a02-e7035489c3e6", "de17f418-ae89-4f1a-a05f-cea287413f90",
            "de17f418-ae89-4f1a-a05f-cea287413f90", "43514d39-0cfb-44a9-8549-f64563414fb0",
            "43514d39-0cfb-44a9-8549-f64563414fb0", "b268fd00-b0df-44b6-ac3c-4799220191c1",
            "b268fd00-b0df-44b6-ac3c-4799220191c1","0f573738-67e5-4c76-9a33-258f92c57173",
            "0f573738-67e5-4c76-9a33-258f92c57173","484d60f6-2d59-449c-823d-87ea4bb474bd"
    );
	
	public static String apikey1="1276331d-5e40-48e0-9a02-e7035489c3e6";
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
