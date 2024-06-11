package com.liveinfo.livescorei;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liveinfo.livescorei.model.MatchBoardInfo;

@FeignClient(name = "live-match", url = "https://api.cricapi.com") // Assuming the user service runs on localhost:8080

//https://api.cricapi.com/v1/match_info?apikey=1276331d-5e40-48e0-9a02-e7035489c3e6&id=c99e9832-62a5-495d-b33f-f3a149f9441e

public interface LiveMatchClient {
	
	//https://api.cricapi.com/v1/cricScore?apikey=1276331d-5e40-48e0-9a02-e7035489c3e6
//?apikey=1276331d-5e40-48e0-9a02-e7035489c3e6
   @GetMapping("/v1/match_info")
   public MatchBoardInfo matchInfo(@RequestParam("apikey") String apiKey, @RequestParam("id") String id);

}

