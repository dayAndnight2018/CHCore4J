package com.chenghua.extendslite;

public class TimeSpan {
	
	private int year;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	private int month;
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	private int day;
	private int hour;
	private int minute;
	private int second;
	
	public TimeSpan(){
		
		this.year =  0;
		this.month =  0;
		this.day = 0;
		this.hour = 0;
		this.minute = 0;
		this.second = 0;
		
	}
	
	public TimeSpan(int year, int month, int day, int hour, int minute, int second){
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		
	}
	
	public long TotalDays() {
		return this.day;
	}
	
	public long TotalHours() {
		return this.day * 24  + this.hour;
	}
	
	public long TotalMinutes() {
		return TotalHours() * 60 + this.minute;
	}
	
	public long TotalSeconds() {
		return TotalMinutes() * 60 + this.second;
	}
	
	public long TotalMilliSeconds() {
		return TotalSeconds() * 1000 ;
	}
	
}
