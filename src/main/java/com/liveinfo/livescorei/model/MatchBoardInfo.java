package com.liveinfo.livescorei.model;


public class MatchBoardInfo {
    private String apikey;
    private Data data;
    private String status;
    private Info info;



	private MatchBoardInfo(Builder builder) {
		this.apikey = builder.apikey;
		this.data = builder.data;
		this.status = builder.status;
		this.info = builder.info;
	}
    
    
    
	 MatchBoardInfo() {
	}
	
	
	
	public String getApikey() {
		return apikey;
	}
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}



	public static Builder builder() {
		return new Builder();
	}
	public static final class Builder {
		private String apikey;
		private Data data;
		private String status;
		private Info info;

		public Builder() {
		}

		public Builder withApikey(String apikey) {
			this.apikey = apikey;
			return this;
		}

		public Builder withData(Data data) {
			this.data = data;
			return this;
		}

		public Builder withStatus(String status) {
			this.status = status;
			return this;
		}

		public Builder withInfo(Info info) {
			this.info = info;
			return this;
		}

		public MatchBoardInfo build() {
			return new MatchBoardInfo(this);
		}
	}

    
    
    
    // Getters and setters
}

