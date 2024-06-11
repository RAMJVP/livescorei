package com.liveinfo.livescorei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@ComponentScan("com.liveinfo.livescorei") 
@EnableFeignClients
@EnableScheduling
@EnableCaching 
public class LiveScoreiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiveScoreiApplication.class, args);
	}

}
