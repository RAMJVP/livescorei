package com.liveinfo.livescorei.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.time.Duration;
import com.liveinfo.livescorei.LiveMatchClient;
import com.liveinfo.livescorei.LiveServiceClient;
import com.liveinfo.livescorei.model.CricScore;
import com.liveinfo.livescorei.model.Data;
import com.liveinfo.livescorei.model.MatchBoard;
import com.liveinfo.livescorei.model.MatchBoardInfo;
import com.liveinfo.livescorei.model.Score;


@Service
public class CricScoreService {

	@Autowired
	private LiveServiceClient liveServiceClient;
	
	
	@Autowired
	private LiveMatchClient liveMatchClient;
	
   @Autowired 
   private Map<LocalDate, List<MatchBoard>> cacheMap;
	 

  // @Cacheable(value = "methodCache", key = "#root.method.name")
	public CricScore geCricScoreList() {
	   System.out.println("geCricScoreList " + java.time.LocalTime.now());
		return getFromServer();
	}


	private CricScore getFromServer() {
		System.out.println("Computed value at " + java.time.LocalTime.now());
		CricScore filterdScore=new CricScore.Builder().build();
		if(false) {
		try {
			CricScore cricScoreList=liveServiceClient.getCricScore();
			LocalDateTime currentDateTime = LocalDateTime.now().plusDays(4);
			 filterdScore= new CricScore.Builder().withApikey(cricScoreList.getApikey()).withData(cricScoreList.getData().stream().filter
					(m->m.getSeries().equals("ICC Mens T20 World Cup 2024") && m.getMatchType().equals("t20")
					 && ((m.getDateTimeGMT().compareTo(localDateTimeGMT(currentDateTime
							.withHour(0).withMinute(0).withSecond(0).withNano(0))) >= 0 && m.getDateTimeGMT().compareTo(
									currentDateTime.withHour(18).withMinute(29).withSecond(59).withNano(999999999)) <= 0))).
					collect(Collectors.toList())).withStatus(cricScoreList.getStatus()).withInfo(cricScoreList.getInfo()).build();
			
			//System.out.println("cricScoreList "+cricScoreList);
			
		}catch(Exception e) {
			System.err.println("error received "+ e.getCause());
		}

		}
		
		return filterdScore;
	}


	public MatchBoard getMatch() {
		List<MatchBoard> ms=cacheMap.get(LocalDate.now());
		if(Optional.ofNullable(cacheMap.get(LocalDate.now())).isPresent()) {
			return ms.get(0);
		}
		return new MatchBoard.Builder().build();
		
	}

	
	@Cacheable(value = "methodCache", key = "#root.method.name")
	public MatchBoardInfo getMatchBoardInfo(String matchId) {
		System.out.println("Computed value at getMatchBoardInfo " + java.time.LocalTime.now());
		//comment test only
		List<Score> scores=List.of(new Score.Builder().withInning(matchId).witho(20).withr(100).withw(2).build(),
				new Score.Builder().withInning(matchId).witho(18).withr(84).withw(4).build());
		
		Data data=new Data.Builder().withName("IND vs PAK, 17th Match, Group B").withTeams(List.of("IND","PAK")).withScore(scores).build();
		MatchBoardInfo filterdScore=new MatchBoardInfo.Builder().withData(data).build();
		if(false) {
		try {
			//apikey=1276331d-5e40-48e0-9a02-e7035489c3e6&id=c99e9832-62a5-495d-b33f-f3a149f9441e
			return liveMatchClient.matchInfo("1276331d-5e40-48e0-9a02-e7035489c3e6", matchId);
		}catch(Exception e) {
			System.err.println("error received "+ e.getCause());
		}
		}
		return filterdScore;
	}
	
	
	
	
	private static LocalDateTime localDateTimeGMT(LocalDateTime startOfDay){
		
		
		//LocalDateTime currentDateTime = LocalDateTime.now();

        // Set the time to 00:00:00.000
       // LocalDateTime startOfDay = currentDateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);

        // Subtract 5 hours and 30 minutes
      
		try {
			Duration durationToSubtract = Duration.ofHours(5).plusMinutes(30);
	        return startOfDay.minus(durationToSubtract);
		
		}catch(Exception e) {
			System.err.println(" error "+e.getCause());
		}
	
        // Print the adjusted date and time
      //  System.out.println("Original DateTime: " + currentDateTime);
       // System.out.println("Start of the Day: " + startOfDay);
       // System.out.println("Adjusted DateTime: " + adjustedDateTime);//Adjusted DateTime: 2024-06-07T18:30:00
        
        
		
		return LocalDateTime.now();
	}
	

}