package com.liveinfo.livescorei.model;

import java.util.Collections;
import java.util.List;

public class Data {
    private String id;
    private String name;
    private String matchType;
    private String status;
    private String venue;
    private String date;
    private String dateTimeGMT;
    private List<String> teams;
    private List<TeamInfo> teamInfo;
    private List<Score> score;
    private String tossWinner;
    private String tossChoice;
    private String matchWinner;
    private String series_id;
    private boolean fantasyEnabled;
    private boolean bbbEnabled;
    private boolean hasSquad;
    private boolean matchStarted;
    private boolean matchEnded;
	private Data(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.matchType = builder.matchType;
		this.status = builder.status;
		this.venue = builder.venue;
		this.date = builder.date;
		this.dateTimeGMT = builder.dateTimeGMT;
		this.teams = builder.teams;
		this.teamInfo = builder.teamInfo;
		this.score = builder.score;
		this.tossWinner = builder.tossWinner;
		this.tossChoice = builder.tossChoice;
		this.matchWinner = builder.matchWinner;
		this.series_id = builder.series_id;
		this.fantasyEnabled = builder.fantasyEnabled;
		this.bbbEnabled = builder.bbbEnabled;
		this.hasSquad = builder.hasSquad;
		this.matchStarted = builder.matchStarted;
		this.matchEnded = builder.matchEnded;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMatchType() {
		return matchType;
	}
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDateTimeGMT() {
		return dateTimeGMT;
	}
	public void setDateTimeGMT(String dateTimeGMT) {
		this.dateTimeGMT = dateTimeGMT;
	}
	public List<String> getTeams() {
		return teams;
	}
	public void setTeams(List<String> teams) {
		this.teams = teams;
	}
	public List<TeamInfo> getTeamInfo() {
		return teamInfo;
	}
	public void setTeamInfo(List<TeamInfo> teamInfo) {
		this.teamInfo = teamInfo;
	}
	public List<Score> getScore() {
		return score;
	}
	public void setScore(List<Score> score) {
		this.score = score;
	}
	public String getTossWinner() {
		return tossWinner;
	}
	public void setTossWinner(String tossWinner) {
		this.tossWinner = tossWinner;
	}
	public String getTossChoice() {
		return tossChoice;
	}
	public void setTossChoice(String tossChoice) {
		this.tossChoice = tossChoice;
	}
	public String getMatchWinner() {
		return matchWinner;
	}
	public void setMatchWinner(String matchWinner) {
		this.matchWinner = matchWinner;
	}
	public String getSeries_id() {
		return series_id;
	}
	public void setSeries_id(String series_id) {
		this.series_id = series_id;
	}
	public boolean isFantasyEnabled() {
		return fantasyEnabled;
	}
	public void setFantasyEnabled(boolean fantasyEnabled) {
		this.fantasyEnabled = fantasyEnabled;
	}
	public boolean isBbbEnabled() {
		return bbbEnabled;
	}
	public void setBbbEnabled(boolean bbbEnabled) {
		this.bbbEnabled = bbbEnabled;
	}
	public boolean isHasSquad() {
		return hasSquad;
	}
	public void setHasSquad(boolean hasSquad) {
		this.hasSquad = hasSquad;
	}
	public boolean isMatchStarted() {
		return matchStarted;
	}
	public void setMatchStarted(boolean matchStarted) {
		this.matchStarted = matchStarted;
	}
	public boolean isMatchEnded() {
		return matchEnded;
	}
	public void setMatchEnded(boolean matchEnded) {
		this.matchEnded = matchEnded;
	}
	public static Builder builder() {
		return new Builder();
	}
	public static final class Builder {
		private String id;
		private String name;
		private String matchType;
		private String status;
		private String venue;
		private String date;
		private String dateTimeGMT;
		private List<String> teams = Collections.emptyList();
		private List<TeamInfo> teamInfo = Collections.emptyList();
		private List<Score> score = Collections.emptyList();
		private String tossWinner;
		private String tossChoice;
		private String matchWinner;
		private String series_id;
		private boolean fantasyEnabled;
		private boolean bbbEnabled;
		private boolean hasSquad;
		private boolean matchStarted;
		private boolean matchEnded;

		public Builder() {
		}

		public Builder withId(String id) {
			this.id = id;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withMatchType(String matchType) {
			this.matchType = matchType;
			return this;
		}

		public Builder withStatus(String status) {
			this.status = status;
			return this;
		}

		public Builder withVenue(String venue) {
			this.venue = venue;
			return this;
		}

		public Builder withDate(String date) {
			this.date = date;
			return this;
		}

		public Builder withDateTimeGMT(String dateTimeGMT) {
			this.dateTimeGMT = dateTimeGMT;
			return this;
		}

		public Builder withTeams(List<String> teams) {
			this.teams = teams;
			return this;
		}

		public Builder withTeamInfo(List<TeamInfo> teamInfo) {
			this.teamInfo = teamInfo;
			return this;
		}

		public Builder withScore(List<Score> score) {
			this.score = score;
			return this;
		}

		public Builder withTossWinner(String tossWinner) {
			this.tossWinner = tossWinner;
			return this;
		}

		public Builder withTossChoice(String tossChoice) {
			this.tossChoice = tossChoice;
			return this;
		}

		public Builder withMatchWinner(String matchWinner) {
			this.matchWinner = matchWinner;
			return this;
		}

		public Builder withSeries_id(String series_id) {
			this.series_id = series_id;
			return this;
		}

		public Builder withFantasyEnabled(boolean fantasyEnabled) {
			this.fantasyEnabled = fantasyEnabled;
			return this;
		}

		public Builder withBbbEnabled(boolean bbbEnabled) {
			this.bbbEnabled = bbbEnabled;
			return this;
		}

		public Builder withHasSquad(boolean hasSquad) {
			this.hasSquad = hasSquad;
			return this;
		}

		public Builder withMatchStarted(boolean matchStarted) {
			this.matchStarted = matchStarted;
			return this;
		}

		public Builder withMatchEnded(boolean matchEnded) {
			this.matchEnded = matchEnded;
			return this;
		}

		public Data build() {
			return new Data(this);
		}
	}
    
    
    
    

    // Getters and setters
}

