package com.chenghua.extendslite;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.chenghua.exceptions.InValidConstructorArgs;
import com.chenghua.exceptions.InValidInputException;

public class DateTime {

	private Date date;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;
	private int dayOfWeek;
	private int dayOfYear;

	public int getDayOfYear() {
		int[] days = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		days[1] = getYear() % 400 == 0 || getYear() % 4 == 0 ? 29 : 28;
		int temp = 0;
		for(int i = 0; i < getMonth() - 1; i++)
		{
			temp+=days[i];
		}
		
		return (temp + getDay()); 
	}

	/***
	 * 获取年份
	 * 
	 * @return
	 */
	public int getYear() {
		return year;
	}

	/***
	 * 设置年份
	 * 
	 * @param year
	 * @throws InValidConstructorArgs
	 */
	public void setYear(int year) throws InValidConstructorArgs {
		this.year = year;

		if (year < 1900) {
			throw new InValidConstructorArgs("The arguments are invalid.");
		}

		this.date.setYear(year - 1900);
		this.dayOfWeek = date.getDay() == 0 ? 7 : date.getDay();
	}

	/***
	 * 获取月份
	 * 
	 * @return
	 */
	public int getMonth() {
		return month;
	}

	/***
	 * 设置月份
	 * 
	 * @param month
	 * @throws InValidConstructorArgs
	 */
	public void setMonth(int month) throws InValidConstructorArgs {
		this.month = month;

		if (month < 1 || month > 12) {
			throw new InValidConstructorArgs("The arguments are invalid.");
		}

		this.date.setMonth(month - 1);
		this.dayOfWeek = date.getDay() == 0 ? 7 : date.getDay();
	}

	/***
	 * 获取日期
	 * 
	 * @return
	 */
	public int getDay() {
		return day;
	}

	/***
	 * 设置日期
	 * 
	 * @param day
	 * @throws InValidConstructorArgs
	 */
	@SuppressWarnings("deprecation")
	public void setDay(int day) throws InValidConstructorArgs {
		this.day = day;

		if (day < 1) {
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
		this.dayOfWeek = date.getDay() == 0 ? 7 : date.getDay();
	}

	/***
	 * 获取小时
	 * 
	 * @return
	 */
	public int getHour() {
		return hour;
	}

	/***
	 * 设置小时
	 * 
	 * @param hour
	 * @throws InValidConstructorArgs
	 */
	public void setHour(int hour) throws InValidConstructorArgs {
		this.hour = hour;

		if (hour < 0 || hour > 24) {
			throw new InValidConstructorArgs("The arguments are invalid.");
		}

		this.date.setHours(hour);
	}

	/***
	 * 获取分钟
	 * 
	 * @return
	 */
	public int getMinute() {
		return minute;
	}

	/***
	 * 设置分钟数
	 * 
	 * @param minute
	 * @throws InValidConstructorArgs
	 */
	public void setMinute(int minute) throws InValidConstructorArgs {

		this.minute = minute;

		if (minute < 0 || minute > 60) {
			throw new InValidConstructorArgs("The arguments are invalid.");
		}

		this.date.setMinutes(minute);
	}

	/***
	 * 获取秒
	 * 
	 * @return
	 */
	public int getSecond() {
		return second;
	}

	/***
	 * 设置秒
	 * 
	 * @param second
	 * @throws InValidConstructorArgs
	 */
	public void setSecond(int second) throws InValidConstructorArgs {
		this.second = second;

		if (second < 0 || second > 60) {
			throw new InValidConstructorArgs("The arguments are invalid.");
		}

		this.date.setSeconds(second);
	}

	/**
	 * 获取星期
	 * 
	 * @return
	 */
	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public DateTime() {
		this.date = new Date();
		this.year = date.getYear() + 1900;
		this.month = date.getMonth() + 1;
		this.day = date.getDate();
		this.hour = date.getHours();
		this.minute = date.getMinutes();
		this.second = date.getSeconds();
		this.dayOfWeek = date.getDay() == 0 ? 7 : date.getDay();
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
		this.dayOfWeek = date.getDay() == 0 ? 7 : date.getDay();
	}

	/**
	 * 当前时间
	 * 
	 * @return
	 */
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

	public String description2()
    {
        DateTime now = DateTime.now();
        if(this.after(now))
        {
            return "未来";
        }

        long totalSeconds = now.minus(this).TotalSeconds();
        String str = null;

        if (totalSeconds <= 60 * 3)
        {
            str = "刚刚";
        }
        else if (totalSeconds <= 60 * 5)
        {
            str = "5分钟前";
        }
        else if (totalSeconds <= 60 * 10)
        {
            str = "10分钟前";
        }
        else if (totalSeconds <= 60 * 15)
        {
            str = "15分钟前";
        }
        else if (totalSeconds <= 60 * 30)
        {
            str = "半小时前";
        }
        else if (totalSeconds <= 60 * 60)
        {
            str = "1小时前";
        }
        else if (totalSeconds <= 60 * 60 * 24)
        {
            str = (int)(totalSeconds / 3600) + "小时前";
        }
        else if (totalSeconds <= 60 * 60 * 24 * 30)
        {
            str = (int)(totalSeconds / 3600 / 24) + "天前";
        }
        else if (totalSeconds < 60 * 60 * 24 * 30 * 12)
        {
            str = (int)(totalSeconds / 3600 / 24 / 30) + "个月前";
        }
        else
        {
            str = (int)(totalSeconds / 3600 / 24 / 30 / 12) + "年前";
        }
        return str;
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

	/***
	 * 获取当前对象的副本
	 * 
	 * @return
	 * @throws InValidConstructorArgs
	 */
	public DateTime copy() throws InValidConstructorArgs {
		return new DateTime(this.getYear(), this.getMonth(), this.getDay(), this.getHour(), this.getMinute(),
				this.getSecond());
	}

	/***
	 * 添加時間
	 * 
	 * @param timeSpan
	 * @return
	 * @throws InValidConstructorArgs
	 * @throws InValidInputException 
	 */
	public DateTime add(TimeSpan timeSpan) throws InValidConstructorArgs, InValidInputException {

		if(timeSpan.getYear() < 0 || timeSpan.getMonth() < 0 || timeSpan.getDay() < 0 || timeSpan.getHour() < 0 || timeSpan.getMinute() <0 ||timeSpan.getSecond() < 0)
		{
			throw new InValidInputException();
		}
		
		DateTime date = this.copy();

		int minute = 0;
		if (timeSpan.getSecond() > 0) {

			minute = (date.getSecond() + timeSpan.getSecond()) / 60;
			date.setSecond((date.getSecond() + timeSpan.getSecond()) % 60);

		}

		int hour = 0;
		if (minute > 0 || timeSpan.getMinute() > 0) {

			hour = (date.getMinute() + timeSpan.getMinute() + minute) / 60;
			date.setMinute((date.getMinute() + timeSpan.getMinute() + minute) % 60);

		}

		int day = 0;
		if (hour > 0 || timeSpan.getHour() > 0) {

			day = (date.getHour() + timeSpan.getHour() + hour) / 24;
			date.setHour((date.getHour() + timeSpan.getHour() + hour) % 24);

		}

		int[] days = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (days[date.getMonth() - 1] > (date.getDay() + timeSpan.getDay() + day)) {
			date.setDay((date.getDay() + timeSpan.getDay() + day));
			date.setMonth((date.getMonth() + timeSpan.getMonth()) % 12 == 0 ? 12
					: (date.getMonth() + timeSpan.getMonth()) % 12);
			date.setYear((date.getYear() + timeSpan.getYear() + (date.getMonth() + timeSpan.getMonth()) / 12));
		} else {
			int totalDays = timeSpan.getDay() + day;
			int pointer = date.getMonth() - 1;
			while (totalDays > 0) {

				if (totalDays + date.getDay() > days[pointer]) {

					totalDays -= (days[pointer] - date.getDay() + 1);
					date.setDay(1);

					pointer++;
					if (pointer == 12) {
						date.setMonth(1);
						date.setYear(date.getYear() + 1);
						days[1] = date.getYear() % 400 == 0 || date.getYear() % 4 == 0 ? 29 : 28;
						pointer = 0;
					} else {
						date.setMonth(pointer + 1);
					}

				} else {
					date.setDay(date.getDay() + totalDays);
					totalDays = 0;
					int month = date.getMonth() + timeSpan.getMonth();
					if (month % 12 == 0) {
						date.setMonth(1);
					} else {
						date.setMonth(month % 12);
					}
					date.setYear(date.getYear() + timeSpan.getYear() + month / 12);
				}
			}
		}

		return date;

	}

	public DateTime minus(TimeSpan timeSpan) throws InValidConstructorArgs, InValidInputException {

		if(timeSpan.getYear() < 0 || timeSpan.getMonth() < 0 || timeSpan.getDay() < 0 || timeSpan.getHour() < 0 || timeSpan.getMinute() <0 ||timeSpan.getSecond() < 0)
		{
			throw new InValidInputException();
		}
		
		DateTime date = this.copy();

		int minute = 0;

		int second = timeSpan.getSecond() % 60;
		if (date.getSecond() - second >= 0) {

			minute = timeSpan.getMinute() + timeSpan.getSecond() / 60;
			date.setSecond(date.getSecond() - second);

		} else {

			minute = timeSpan.getMinute() + timeSpan.getSecond() / 60 + 1;
			date.setSecond(date.getSecond() + 60 - second);

		}

		int hour = 0;

		int realMinute = minute % 60;
		if (date.getMinute() - realMinute >= 0) {

			hour = timeSpan.getHour() + minute / 60;
			date.setMinute(date.getMinute() - realMinute);

		} else {

			hour = timeSpan.getHour() + minute / 60 + 1;
			date.setMinute(date.getMinute() + 60 - realMinute);

		}

		int day = 0;

		int realHour = hour % 24;
		if (date.getHour() - realHour >= 0) {

			day = timeSpan.getDay() + hour / 24;
			date.setHour(date.getHour() - realHour);

		} else {
			day = timeSpan.getDay() + hour / 24 + 1;
			date.setHour(date.getHour() + 24 - realHour);
		}

		int[] days = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (date.getDay() > day) {

			date.setDay((date.getDay() - day));

			int realMonth = timeSpan.getMonth() % 12;
			int year = 0;
			if (date.getMonth() - realMonth > 0) {

				year = timeSpan.getMonth() / 12 + timeSpan.getYear();
				date.setMonth(date.getMonth() - realMonth);

			} else {

				year = timeSpan.getMonth() / 12 + timeSpan.getYear() + 1;
				date.setMonth(date.getMonth() + 12 - realMonth);
			}
			date.setYear(date.getYear() - year);

		} else {

			int totalDays = day;
			int pointer = date.getMonth() - 1;
			while (totalDays > 0) {

				if (date.getDay() <= totalDays) {

					pointer--;
					if (pointer == -1) {
						date.setMonth(12);
						date.setYear(date.getYear() - 1);
						days[1] = date.getYear() % 400 == 0 || date.getYear() % 4 == 0 ? 29 : 28;
						pointer = 11;
					} else {
						date.setMonth(pointer - 1);
					}

					date.setDay(days[pointer]);
					totalDays -= date.getDay();

				} else {
					date.setDay(date.getDay() - totalDays);
					totalDays = 0;

					int realMonth = timeSpan.getMonth() % 12;
					int year = 0;
					if (date.getMonth() - realMonth > 0) {

						year = timeSpan.getMonth() / 12 + timeSpan.getYear();
						date.setMonth(date.getMonth() - realMonth);

					} else {

						year = timeSpan.getMonth() / 12 + timeSpan.getYear() + 1;
						date.setMonth(date.getMonth() + 12 - realMonth);
					}
					date.setYear(date.getYear() - year);

				}
			}
		}

		return date;
	}

	public TimeSpan minus(DateTime date) {
		
		DateTime old = this.after(date)?this:date;
		DateTime young = this.after(date)?date:this;
		
		TimeSpan span = new TimeSpan(0,0,old.getDay(),old.getHour(),old.getMinute(),old.getSecond());

		int minute = 0;

		int second = young.getSecond() % 60;
		if (span.getSecond() - second >= 0) {

			minute = young.getMinute() + young.getSecond() / 60;
			span.setSecond(span.getSecond() - second);

		} else {

			minute = young.getMinute() + young.getSecond() / 60 + 1;
			span.setSecond(span.getSecond() + 60 - second);

		}

		int hour = 0;

		int realMinute = minute % 60;
		if (span.getMinute() - realMinute >= 0) {

			hour = young.getHour() + minute / 60;
			span.setMinute(span.getMinute() - realMinute);

		} else {

			hour = young.getHour() + minute / 60 + 1;
			span.setMinute(span.getMinute() + 60 - realMinute);

		}

		int day = 0;

		int realHour = hour % 24;
		if (span.getHour() - realHour >= 0) {

			day = young.getDay() + hour / 24;
			span.setHour(span.getHour() - realHour);

		} else {
			day = young.getDay() + hour / 24 + 1;
			span.setHour(span.getHour() + 24 - realHour);
		}

		int days = (int)(old.date.getTime() - young.date.getTime())/1000/60/60/24;
		span.setDay(days);
		return span;
	}
	/**
	 * 加上指定的天數
	 * @param year
	 * @return
	 * @throws InValidConstructorArgs
	 * @throws InValidInputException 
	 */
	public DateTime addYears(int year) throws InValidConstructorArgs, InValidInputException {
		
		if(year >= 0)
			return this.copy().add(new TimeSpan(year,0,0,0,0,0));
		else
			return this.copy().minus(new TimeSpan(0-year,0,0,0,0,0));
		
	}
	
	/**
	 * 加上指定月份
	 * @param month
	 * @return
	 * @throws InValidConstructorArgs
	 * @throws InValidInputException
	 */
	public DateTime addMonths(int month) throws InValidConstructorArgs, InValidInputException{
		if(month >= 0)
			return this.copy().add(new TimeSpan(0,month,0,0,0,0));
		else
			return this.copy().minus(new TimeSpan(0,0 - month,0,0,0,0));
	}
	
	/**
	 * 加上指定天數
	 * @param day
	 * @return
	 * @throws InValidConstructorArgs
	 * @throws InValidInputException
	 */
	public DateTime addDays(int day) throws InValidConstructorArgs, InValidInputException{
		if(day >= 0)
			return this.copy().add(new TimeSpan(0,0,day,0,0,0));
		else
			return this.copy().minus(new TimeSpan(0,0,0 - day,0,0,0));
	}
	
	/**
	 * 加上指定小時
	 * @param hour
	 * @return
	 * @throws InValidConstructorArgs
	 * @throws InValidInputException
	 */
	public DateTime addHours(int hour) throws InValidConstructorArgs, InValidInputException{
		if(hour >= 0)
			return this.copy().add(new TimeSpan(0,0,0,hour,0,0));
		else
			return this.copy().minus(new TimeSpan(0,0,0 ,0-hour,0,0));
	}
	
	/**
	 * 加上制定分鐘
	 * @param minute
	 * @return
	 * @throws InValidConstructorArgs
	 * @throws InValidInputException
	 */
	public DateTime addMinutes(int minute) throws InValidConstructorArgs, InValidInputException{
		if(minute > 0)
			return this.copy().add(new TimeSpan(0,0,0,0,minute,0));
		else
			return this.copy().minus(new TimeSpan(0,0,0,0,0-minute,0));
	}
	
	/**
	 * 加上指定秒
	 * @param second
	 * @return
	 * @throws InValidConstructorArgs
	 * @throws InValidInputException
	 */
	public DateTime addSeconds(int second) throws InValidConstructorArgs, InValidInputException{
		if(second > 0)
			return this.copy().add(new TimeSpan(0,0,0,0,0,second));
		else
			return this.copy().minus(new TimeSpan(0,0,0,0,0,0-second));
	}
		
	/**
	 * 获取天数
	 * 
	 * @param month
	 * @return
	 * @throws InValidInputException
	 */
	private int daysOfMonth(int month) throws InValidInputException {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if (year % 4 == 0 || year % 400 == 0) {
				return 29;
			} else {
				return 28;
			}
		default:
			throw new InValidInputException();
		}
	}

}

