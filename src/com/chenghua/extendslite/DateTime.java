package com.chenghua.extendslite;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.chenghua.exceptions.InValidConstructorArgs;

public class DateTime {

	private Date date;

	private int year;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) throws InValidConstructorArgs {
		this.year = year;
		
		if (year < 1900) 
		{
			throw new InValidConstructorArgs("The arguments are invalid.");
		}
		
		this.date.setYear(year - 1900);
		this.dayOfWeek = date.getDay() == 0 ? 7 :date.getDay();
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) throws InValidConstructorArgs {
		this.month = month;
		
		if (month < 1 || month > 12 ) 
		{
			throw new InValidConstructorArgs("The arguments are invalid.");
		}
		
		this.date.setMonth(month - 1); 
		this.dayOfWeek = date.getDay() == 0 ? 7 :date.getDay();
	}

	public int getDay() {
		return day;
	}

	@SuppressWarnings("deprecation")
	public void setDay(int day) throws InValidConstructorArgs {
		this.day = day;
		
		if (day < 1 )
		{
			throw new InValidConstructorArgs("The arguments are invalid.");
		}

		switch (this.month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (day > 31) {
				throw new InValidConstructorArgs("The day of the month is invalid.");
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (day > 30) {
				throw new InValidConstructorArgs("The day of the month is invalid.");
			}
			break;
		case 2:
			if (year % 4 == 0 || year % 400 == 0) {
				if (day > 29) {
					throw new InValidConstructorArgs("The day of the month is invalid.");
				}
			} else {
				if (day > 28) {
					throw new InValidConstructorArgs("The day of the month is invalid.");
				}
			}
			break;
		default:
			throw new InValidConstructorArgs("The day of the month is invalid.");
		}
		
		this.date.setDate(day);
		this.dayOfWeek = date.getDay() == 0 ? 7 :date.getDay();
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) throws InValidConstructorArgs {
		this.hour = hour;
		
		if (hour < 0 || hour > 24 ) 
		{
			throw new InValidConstructorArgs("The arguments are invalid.");
		}
		
		this.date.setHours(hour);
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) throws InValidConstructorArgs {
		
		this.minute = minute;
		
		if ( minute < 0 || minute > 60) 
		{
			throw new InValidConstructorArgs("The arguments are invalid.");
		}
		
		this.date.setMinutes(minute);
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) throws InValidConstructorArgs {
		this.second = second;
		
		if ( second < 0 || second > 60) 
		{
			throw new InValidConstructorArgs("The arguments are invalid.");
		}
		
		this.date.setSeconds(second);
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	private int month;
	private int day;

	private int hour;
	private int minute;
	private int second;

	private int dayOfWeek;

	public DateTime() {
		this.date = new Date();
		this.year = date.getYear() + 1900;
		this.month = date.getMonth() + 1;
		this.day = date.getDate();
		this.hour = date.getHours();
		this.minute = date.getMinutes();
		this.second = date.getSeconds();
		this.dayOfWeek = date.getDay() == 0 ? 7 :date.getDay();
	}

	@SuppressWarnings("deprecation")
	public DateTime(int year, int month, int day) throws InValidConstructorArgs {
		this(year, month, day, 0, 0, 0);
	}

	@SuppressWarnings("deprecation")
	public DateTime(int year, int month, int day, int hour, int minute, int second) throws InValidConstructorArgs {
		if (year < 1900 || month < 1 || month > 12 || day < 1 || hour < 0 || hour > 24 || minute < 0 || minute > 60
				|| second < 0 || second > 60) {
			throw new InValidConstructorArgs("The arguments are invalid.");
		}

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (day > 31) {
				throw new InValidConstructorArgs("The day of the month is invalid.");
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (day > 30) {
				throw new InValidConstructorArgs("The day of the month is invalid.");
			}
			break;
		case 2:
			if (year % 4 == 0 || year % 400 == 0) {
				if (day > 29) {
					throw new InValidConstructorArgs("The day of the month is invalid.");
				}
			} else {
				if (day > 28) {
					throw new InValidConstructorArgs("The day of the month is invalid.");
				}
			}
			break;
		default:
			throw new InValidConstructorArgs("The day of the month is invalid.");
		}

		this.date = new Date(year - 1900, month - 1, day, hour, minute, second);
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.dayOfWeek = date.getDay() == 0 ? 7 :date.getDay();
	}

	public static DateTime now() {
		return new DateTime();
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return format.format(this.date);
	}

	public String toDateString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		return format.format(this.date);
	}

	public String toTimeString() {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		return format.format(this.date);
	}

	public String toDateTimeString() {
		return toString();
	}

	public boolean after(DateTime date) {
		return this.date.after(date.date);
	}

	public boolean before(DateTime date) {
		return this.date.before(date.date);
	}

	public boolean equals(DateTime date) {
		return this.year == date.year && this.month == date.month && this.day == date.day && this.hour == date.hour
				&& this.minute == date.minute && this.second == this.second;
	}

	public String description() {
		DateTime now = DateTime.now();
		if (this.equals(now)) {
			return "现在";
		} else if (this.before(now)) {
			return "过去";
		} else {
			return "将来";
		}
	}

	public String dayOfWeek() {
		switch (this.dayOfWeek) {
		case 1:
			return "星期一";
		case 2:
			return "星期二";
		case 3:
			return "星期三";
		case 4:
			return "星期四";
		case 5:
			return "星期五";
		case 6:
			return "星期六";
		case 7:
			return "星期日";
		default:
			return "未知";
		}
	}
	
	public String dayOfWeek2() {
		switch (this.dayOfWeek) {
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Saturday";
		case 7:
			return "Sunday";
		default:
			return "Unknown";
		}
	}
}
