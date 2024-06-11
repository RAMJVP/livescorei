package com.liveinfo.livescorei.model;


public class MatchBoard {
	
	private String id;
	private String t1;
	private String t2;
	private String dateTimeGMT;
	private long tStamp;
	
	MatchBoard(){
		
	}
	
	
	private MatchBoard(Builder builder) {
		this.id = builder.id;
		this.t1 = builder.t1;
		this.t2 = builder.t2;
		this.dateTimeGMT = builder.dateTimeGMT;
		this.tStamp = builder.tStamp;
	}
	
	public static final class Builder {
		private String id;
		private String t1;
		private String t2;
		private String dateTimeGMT;
		private long tStamp;

		public Builder() {
		}

		public Builder withId(String id) {
			this.id = id;
			return this;
		}

		public Builder withT1(String t1) {
			this.t1 = t1;
			return this;
		}

		public Builder withT2(String t2) {
			this.t2 = t2;
			return this;
		}

		public Builder withDateTimeGMT(String dateTimeGMT) {
			this.dateTimeGMT = dateTimeGMT;
			return this;
		}

		public Builder withTStamp(long tStamp) {
			this.tStamp = tStamp;
			return this;
		}

		public MatchBoard build() {
			return new MatchBoard(this);
		}
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getT1() {
		return t1;
	}


	public void setT1(String t1) {
		this.t1 = t1;
	}


	public String getT2() {
		return t2;
	}


	public void setT2(String t2) {
		this.t2 = t2;
	}


	public String getDateTimeGMT() {
		return dateTimeGMT;
	}


	public void setDateTimeGMT(String dateTimeGMT) {
		this.dateTimeGMT = dateTimeGMT;
	}


	public long gettStamp() {
		return tStamp;
	}


	public void settStamp(long tStamp) {
		this.tStamp = tStamp;
	}
	

}
