package com.liveinfo.livescorei;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.liveinfo.livescorei.model.CricScore;

@FeignClient(name = "live-service", url = "https://api.cricapi.com") // Assuming the user service runs on localhost:8080
public interface LiveServiceClient {
	
	//https://api.cricapi.com/v1/cricScore?apikey=1276331d-5e40-48e0-9a02-e7035489c3e6

    @GetMapping("/v1/cricScore?apikey=1276331d-5e40-48e0-9a02-e7035489c3e6")
   CricScore getCricScore();

}

