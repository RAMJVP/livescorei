package com.liveinfo.livescorei.model;

public class Score {
    private int r;
    private int w;
    private int o;
    private String inning;
    
    Score(){
    	
    }
    
	private Score(Builder builder) {
		this.r = builder.r;
		this.w = builder.w;
		this.o = builder.o;
		this.inning = builder.inning;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getO() {
		return o;
	}
	public void setO(int o) {
		this.o = o;
	}
	public String getInning() {
		return inning;
	}
	public void setInning(String inning) {
		this.inning = inning;
	}
	public static Builder builder() {
		return new Builder();
	}
	public static final class Builder {
		private int r;
		private int w;
		private int o;
		private String inning;

		public Builder() {
		}

		public Builder withr(int r) {
			this.r = r;
			return this;
		}

		public Builder withw(int w) {
			this.w = w;
			return this;
		}

		public Builder witho(int o) {
			this.o = o;
			return this;
		}

		public Builder withInning(String inning) {
			this.inning = inning;
			return this;
		}

		public Score build() {
			return new Score(this);
		}
	}
    
	
	
    

    // Getters and setters
}

