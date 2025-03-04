package com.liveinfo.livescorei;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liveinfo.livescorei.constant.LiveInfoConstant;
import com.liveinfo.livescorei.model.CricScore;
import com.liveinfo.livescorei.model.MatchBoard;
import com.liveinfo.livescorei.model.MatchBoardInfo;
import com.liveinfo.livescorei.service.CricScoreService;
import com.liveinfo.livescorei.service.FlagService;

@RestController
public class LiveScoreController {
	
	@Autowired
	private CricScoreService cricScoreService;
	
	
	@Autowired
	private FlagService flagService;
	
	
	
	@GetMapping("livescore")
	public CricScore cricScore(@RequestParam("lapikey") String lapikey) {
		if(Optional.ofNullable(lapikey).isPresent()) {
			if(LiveInfoConstant.lapikey.equals(lapikey)) {
				return cricScoreService.geCricScoreList();
			}	
		}
		return new CricScore.Builder().build();
	}
	
	//get from local cache
	@PostMapping("match")
	public MatchBoard match1(@RequestParam("lapikey") String lapikey) {
		System.out.println("new imp");
		if(Optional.ofNullable(lapikey).isPresent()) {
			if(LiveInfoConstant.lapikey.equals(lapikey)) {
				System.out.println("cricScoreService.getMatch();##"+cricScoreService.getMatch());
				return cricScoreService.getMatch();
			}	
		}
		return new MatchBoard.Builder().build();
	}
	
	/*
	 * @GetMapping("match") public MatchBoard match(@RequestParam("lapikey") String
	 * lapikey) {
	 * 
	 * if(Optional.ofNullable(lapikey).isPresent()) {
	 * if(LiveInfoConstant.lapikey.equals(lapikey)) { return
	 * cricScoreService.getMatch(); } } return new MatchBoard.Builder().build(); }
	 */
	
	@GetMapping("/flag")
    public boolean getFlag() {
        return flagService.isFlag();
    }
	
	@GetMapping("/tsflag")
    public boolean tsFlag(@RequestParam(value = "ts", defaultValue = "0") long ts) {
      boolean res=flagService.tsFlag(ts);
	System.out.println("res "+res+" ts "+ts);
		return res;
    }
	
	
	/*
	 * @GetMapping("matchboardinfo") public MatchBoardInfo
	 * matchBoardInfo(@RequestParam("lapikey") String lapikey,@RequestParam("id")
	 * String id) { System.out.println("exi imp");
	 * if(Optional.ofNullable(lapikey).isPresent()) {
	 * if(LiveInfoConstant.lapikey.equals(lapikey)) { return
	 * cricScoreService.getMatchBoardInfo(id); } } return new
	 * MatchBoardInfo.Builder().build(); }
	 */
	

	@PostMapping("matchboardinfo")
	public MatchBoardInfo matchBoardInfo1(@RequestParam("lapikey") String lapikey,@RequestParam("id") String id) {
		
		System.out.println("new imp");
		if(Optional.ofNullable(lapikey).isPresent()) {
			if(LiveInfoConstant.lapikey.equals(lapikey)) {
				return cricScoreService.getMatchBoardInfo(id);
			}	
		}
		return new MatchBoardInfo.Builder().build();
	}
	
	
	
	
	
}
