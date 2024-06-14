package com.liveinfo.livescorei.model;

public class Info {
    private int hitsToday;
    private int hitsUsed;
    private int hitsLimit;
    private int credits;
    private int server;
    private int offsetRows;
    private int totalRows;
    private double queryTime;
    private int s;
    private int cache;

    
    Info(){
    	
    }
    
    // Getters and Setters
    public int getHitsToday() {
        return hitsToday;
    }

    public void setHitsToday(int hitsToday) {
        this.hitsToday = hitsToday;
    }

    public int getHitsUsed() {
        return hitsUsed;
    }

    public void setHitsUsed(int hitsUsed) {
        this.hitsUsed = hitsUsed;
    }

    public int getHitsLimit() {
        return hitsLimit;
    }

    public void setHitsLimit(int hitsLimit) {
        this.hitsLimit = hitsLimit;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getServer() {
        return server;
    }

    public void setServer(int server) {
        this.server = server;
    }

    public int getOffsetRows() {
        return offsetRows;
    }

    public void setOffsetRows(int offsetRows) {
        this.offsetRows = offsetRows;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public double getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(double queryTime) {
        this.queryTime = queryTime;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getCache() {
        return cache;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }
}

