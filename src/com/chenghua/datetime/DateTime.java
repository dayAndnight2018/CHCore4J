package com.chenghua.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.chenghua.exceptions.InvalidConstructorArgs;
import com.chenghua.exceptions.InvalidInputException;

/**
 * DateTime is a extend of Date class
 */
public class DateTime {

    /**
     * properties
     */
    private Date date;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private int dayOfWeek;
    private int dayOfYear;

    /***
     * get current day of current year
     * @return
     */
    public int getDayOfYear() {
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        days[1] = getYear() % 400 == 0 || getYear() % 4 == 0 ? 29 : 28;
        int temp = 0;
        for (int i = 0; i < getMonth() - 1; i++) {
            temp += days[i];
        }
        return (temp + getDay());
    }

    /***
     * get year
     *
     * @return
     */
    public int getYear() {
        return year;
    }

    /***
     * set year
     * @param year
     * @throws InvalidInputException
     */
    public void setYear(int year) throws InvalidInputException {
        if (year < 1900) {
            throw new InvalidInputException("The arguments are invalid.");
        }
        this.year = year;
        this.date.setYear(year - 1900);
        this.dayOfWeek = date.getDay() == 0 ? 7 : date.getDay();
    }

    /***
     * get month
     * @return
     */
    public int getMonth() {
        return month;
    }

    /***
     * set month
     * @param month
     * @throws InvalidInputException
     */
    public void setMonth(int month) throws InvalidInputException {
        if (month < 1 || month > 12) {
            throw new InvalidInputException("The arguments are invalid.");
        }
        this.month = month;
        this.date.setMonth(month - 1);
        this.dayOfWeek = date.getDay() == 0 ? 7 : date.getDay();
    }

    /***
     * get date
     * @return
     */
    public int getDay() {
        return day;
    }

    /***
     * set date
     * @param day
     * @throws InvalidInputException
     */
    @SuppressWarnings("deprecation")
    public void setDay(int day) throws InvalidInputException {

        if (day < 1) {
            throw new InvalidInputException("The arguments are invalid.");
        }

        this.day = day;
        switch (this.month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31) {
                    throw new InvalidInputException("The day of the month is invalid.");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) {
                    throw new InvalidInputException("The day of the month is invalid.");
                }
                break;
            case 2:
                if (year % 4 == 0 || year % 400 == 0) {
                    if (day > 29) {
                        throw new InvalidInputException("The day of the month is invalid.");
                    }
                } else {
                    if (day > 28) {
                        throw new InvalidInputException("The day of the month is invalid.");
                    }
                }
                break;
            default:
                throw new InvalidInputException("The day of the month is invalid.");
        }

        this.date.setDate(day);
        this.dayOfWeek = date.getDay() == 0 ? 7 : date.getDay();
    }

    /***
     * get hour
     * @return
     */
    public int getHour() {
        return hour;
    }

    /***
     * set hour
     *
     * @param hour
     * @throws InvalidInputException
     */
    public void setHour(int hour) throws InvalidInputException {
        if (hour < 0 || hour > 24) {
            throw new InvalidInputException("The arguments are invalid.");
        }
        this.hour = hour;
        this.date.setHours(hour);
    }

    /***
     * get minute
     * @return
     */
    public int getMinute() {
        return minute;
    }

    /***
     * set minute
     * @param minute
     * @throws InvalidInputException
     */
    public void setMinute(int minute) throws InvalidInputException {
        if (minute < 0 || minute > 60) {
            throw new InvalidInputException("The arguments are invalid.");
        }
        this.minute = minute;
        this.date.setMinutes(minute);
    }

    /***
     * get second
     * @return
     */
    public int getSecond() {
        return second;
    }

    /***
     * set second
     * @param second
     * @throws InvalidInputException
     */
    public void setSecond(int second) throws InvalidInputException {
        if (second < 0 || second > 60) {
            throw new InvalidInputException("The arguments are invalid.");
        }
        this.second = second;
        this.date.setSeconds(second);
    }

    /**
     * get dayofweek
     *
     * @return
     */
    public int getDayOfWeek() {
        return dayOfWeek;
    }

    /***
     * constructors
     */
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

    public DateTime(Date date) {
        this.date = date;
        this.year = date.getYear() + 1900;
        this.month = date.getMonth() + 1;
        this.day = date.getDate();
        this.hour = date.getHours();
        this.minute = date.getMinutes();
        this.second = date.getSeconds();
        this.dayOfWeek = date.getDay() == 0 ? 7 : date.getDay();
    }

    @SuppressWarnings("deprecation")
    public DateTime(int year, int month, int day) throws InvalidConstructorArgs {
        this(year, month, day, 0, 0, 0);
    }

    @SuppressWarnings("deprecation")
    public DateTime(int year, int month, int day, int hour, int minute, int second) throws InvalidConstructorArgs {
        if (year < 1900 || month < 1 || month > 12 || day < 1 || hour < 0 || hour > 24 || minute < 0 || minute > 60
                || second < 0 || second > 60) {
            throw new InvalidConstructorArgs("The arguments are invalid.");
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
                    throw new InvalidConstructorArgs("The day of the month is invalid.");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) {
                    throw new InvalidConstructorArgs("The day of the month is invalid.");
                }
                break;
            case 2:
                if (year % 4 == 0 || year % 400 == 0) {
                    if (day > 29) {
                        throw new InvalidConstructorArgs("The day of the month is invalid.");
                    }
                } else {
                    if (day > 28) {
                        throw new InvalidConstructorArgs("The day of the month is invalid.");
                    }
                }
                break;
            default:
                throw new InvalidConstructorArgs("The day of the month is invalid.");
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

    public DateTime yesterday() throws InvalidInputException {
        TimeSpan span = new TimeSpan();
        span.set(TimeSpanParamEnum.DAY, 1);
        return new DateTime(new Date(this.date.getTime() - span.TotalMilliSeconds()));
    }


    /**
     * get current time
     *
     * @return
     */
    public static DateTime now() {
        return new DateTime();
    }

    /***
     * print methods
     * @return
     */
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

    public String format(DateFormatPatternEnum pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern.getPattern());
        return format.format(this.date);
    }

    /**
     * if this late than obj
     *
     * @param date
     * @return
     */
    public boolean after(DateTime date) {
        return this.date.after(date.date);
    }

    /**
     * if this before than obj
     *
     * @param date
     * @return
     */
    public boolean before(DateTime date) {
        return this.date.before(date.date);
    }

    /**
     * override equals method
     *
     * @param date
     * @return
     */
    public boolean equals(DateTime date) {
        return this.year == date.year && this.month == date.month && this.day == date.day && this.hour == date.hour
                && this.minute == date.minute && this.second == this.second;
    }

    /**
     * offer chinese desc of this "现在"、"过去"、"将来"
     *
     * @return
     */
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

    /**
     * offer chinese desc of this "xxx分钟前"
     *
     * @return
     */
    public String description2() {
        DateTime now = DateTime.now();
        if (this.after(now)) {
            return "未来";
        }

        long totalSeconds = now.minus(this).TotalSeconds();
        String str = null;

        if (totalSeconds <= 60 * 3) {
            str = "刚刚";
        } else if (totalSeconds <= 60 * 5) {
            str = "5分钟前";
        } else if (totalSeconds <= 60 * 10) {
            str = "10分钟前";
        } else if (totalSeconds <= 60 * 15) {
            str = "15分钟前";
        } else if (totalSeconds <= 60 * 30) {
            str = "半小时前";
        } else if (totalSeconds <= 60 * 60) {
            str = "1小时前";
        } else if (totalSeconds <= 60 * 60 * 24) {
            str = (int) (totalSeconds / 3600) + "小时前";
        } else if (totalSeconds <= 60 * 60 * 24 * 30) {
            str = (int) (totalSeconds / 3600 / 24) + "天前";
        } else if (totalSeconds < 60 * 60 * 24 * 30 * 12) {
            str = (int) (totalSeconds / 3600 / 24 / 30) + "个月前";
        } else {
            str = (int) (totalSeconds / 3600 / 24 / 30 / 12) + "年前";
        }
        return str;
    }

    /**
     * offer String desc of dayofweek "星期一"
     *
     * @return
     */
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

    /**
     * offer english desc of dayofweek "Monday"
     *
     * @return
     */
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
     * get copy of this
     *
     * @return
     * @throws InvalidConstructorArgs
     */
    public DateTime copy() throws InvalidConstructorArgs {
        return new DateTime(this.getYear(), this.getMonth(), this.getDay(), this.getHour(), this.getMinute(),
                this.getSecond());
    }

    /***
     * add a certain timespan over this
     *
     * @param timeSpan
     * @return
     * @throws InvalidConstructorArgs
     * @throws InvalidInputException
     */
    public DateTime add(TimeSpan timeSpan) throws InvalidConstructorArgs, InvalidInputException {

        if (timeSpan == null || timeSpan.invalid()) {
            throw new InvalidInputException();
        }

        return new DateTime(new Date(this.date.getTime() + timeSpan.TotalMilliSeconds()));
    }

    /**
     * add a certain timespan over this
     */
    private DateTime minus(TimeSpan timeSpan) throws InvalidConstructorArgs, InvalidInputException {

        if (timeSpan == null || timeSpan.invalid()) {
            throw new InvalidInputException();
        }

        return new DateTime(new Date(this.date.getTime() - timeSpan.TotalMilliSeconds()));
    }

    /**
     * get a timespan result of two datetime diff
     *
     * @param date
     * @return
     */
    public TimeSpan minus(DateTime date) {

        DateTime old = this.after(date) ? this : date;
        DateTime young = this.after(date) ? date : this;

        TimeSpan span = new TimeSpan(0, 0, old.getDay(), old.getHour(), old.getMinute(), old.getSecond());

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

        int days = (int) (old.date.getTime() - young.date.getTime()) / 1000 / 60 / 60 / 24;
        span.setDay(days);
        return span;
    }

    /**
     * add years over this
     *
     * @param year
     * @return
     * @throws InvalidConstructorArgs
     * @throws InvalidInputException
     */
    public DateTime addYears(int year) throws InvalidConstructorArgs, InvalidInputException {
        TimeSpan span = new TimeSpan();
        if (year >= 0) {
            span.set(TimeSpanParamEnum.YEAR, year);
            return this.copy().add(span);
        } else {
            span.set(TimeSpanParamEnum.YEAR, 0 - year);
            return this.copy().minus(span);
        }
    }

    /**
     * add month over this
     *
     * @param month
     * @return
     * @throws InvalidConstructorArgs
     * @throws InvalidInputException
     */
    public DateTime addMonths(int month) throws InvalidConstructorArgs, InvalidInputException {
        TimeSpan span = new TimeSpan();
        if (month >= 0) {
            span.set(TimeSpanParamEnum.MONTH, month);
            return this.copy().add(span);
        } else {
            span.set(TimeSpanParamEnum.MONTH, 0 - month);
            return this.copy().minus(span);
        }
    }

    /**
     * add days over this
     *
     * @param day
     * @return
     * @throws InvalidConstructorArgs
     * @throws InvalidInputException
     */
    public DateTime addDays(int day) throws InvalidConstructorArgs, InvalidInputException {
        TimeSpan span = new TimeSpan();
        if (day >= 0) {
            span.set(TimeSpanParamEnum.DAY, day);
            return this.copy().add(span);
        } else {
            span.set(TimeSpanParamEnum.DAY, 0 - day);
            return this.copy().minus(span);
        }
    }

    /**
     * add hours over this
     *
     * @param hour
     * @return
     * @throws InvalidConstructorArgs
     * @throws InvalidInputException
     */
    public DateTime addHours(int hour) throws InvalidConstructorArgs, InvalidInputException {
        TimeSpan span = new TimeSpan();
        if (hour >= 0) {
            span.set(TimeSpanParamEnum.HOUR, hour);
            return this.copy().add(span);
        } else {
            span.set(TimeSpanParamEnum.HOUR, 0 - hour);
            return this.copy().minus(span);
        }
    }

    /**
     * add minutes over this
     *
     * @param minute
     * @return
     * @throws InvalidConstructorArgs
     * @throws InvalidInputException
     */
    public DateTime addMinutes(int minute) throws InvalidConstructorArgs, InvalidInputException {
        TimeSpan span = new TimeSpan();
        if (minute >= 0) {
            span.set(TimeSpanParamEnum.MINUTE, minute);
            return this.copy().add(span);
        } else {
            span.set(TimeSpanParamEnum.MINUTE, 0 - minute);
            return this.copy().minus(span);
        }
    }

    /**
     * add seconds over this
     *
     * @param second
     * @return
     * @throws InvalidConstructorArgs
     * @throws InvalidInputException
     */
    public DateTime addSeconds(int second) throws InvalidConstructorArgs, InvalidInputException {
        TimeSpan span = new TimeSpan();
        if (second >= 0) {
            span.set(TimeSpanParamEnum.SECOND, second);
            return this.copy().add(span);
        } else {
            span.set(TimeSpanParamEnum.SECOND, 0 - second);
            return this.copy().minus(span);
        }
    }

    /**
     * get total days of this month
     *
     * @param month
     * @return
     * @throws InvalidInputException
     */
    private int daysOfMonth(int month) throws InvalidInputException {
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
                throw new InvalidInputException();
        }
    }

}

