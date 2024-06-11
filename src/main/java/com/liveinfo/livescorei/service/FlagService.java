package com.liveinfo.livescorei.service;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.liveinfo.livescorei.constant.LiveInfoConstant;

import jakarta.annotation.PostConstruct;

@Service
public class FlagService {

    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    
    // Turns the flag ON at 00:30  ### 05:00
    @Scheduled(cron = "0 00 6 * * ?")
    public void turnOnFlagAtNight() {
        flag = true;
        System.out.println("Flag turned on at night: " + java.time.LocalTime.now());
    }

    // Turns the flag OFF at 03:30 ####9:00
    @Scheduled(cron = "0 00 9 * * ?")
    public void turnOffFlagAtNight() {
        flag = false;
        System.out.println("Flag turned off at night: " + java.time.LocalTime.now());
    }

    // Turns the flag ON at 14:30 ##20:00
    @Scheduled(cron = "0 00 20 * * ?")
    public void turnOnFlagInAfternoon() {
        flag = true;
        System.out.println("Flag turned on in the afternoon: " + java.time.LocalTime.now());
    }

    // Turns the flag OFF at 20:00 ##23:59
    @Scheduled(cron = "0 59 23 * * ?")
    public void turnOffFlagInEvening() {
        flag = false;
        System.out.println("Flag turned off in the evening: " + java.time.LocalTime.now());
    }
    
    
    
 // Initialize the flag based on a condition at startup
    @PostConstruct
    public void init() {
    	if(LocalTime.now().compareTo(LiveInfoConstant.TIME_S1)>=0 && LocalTime.now().compareTo(LiveInfoConstant.TIME_E1)<=0) {
    		 flag = true;
    		 System.out.println("Flag turned on in the morning: " + java.time.LocalTime.now());
    	}
    	
    	else if(LocalTime.now().compareTo(LiveInfoConstant.TIME_S2)>=0 && LocalTime.now().compareTo(LiveInfoConstant.TIME_E2)<=0) {
    		 flag = true;
    		 System.out.println("Flag turned on in the evening: " + java.time.LocalTime.now());
    	}
    	else {
    		flag = false;
    		 System.out.println("Flag turned off in the evening: " + java.time.LocalTime.now());
    	}
    }
    
    
    
    
}
