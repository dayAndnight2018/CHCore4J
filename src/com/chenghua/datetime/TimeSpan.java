package com.chenghua.datetime;

import com.chenghua.beans.BeanUtils;
import com.chenghua.exceptions.InvalidInputException;

import java.util.function.Predicate;

/**
 * timespan represent a interval of datetime
 */
public class TimeSpan {

    /**
     * properties
     */
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    /**
     * getters and setters
     *
     * @return
     */
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = BeanUtils.defaultValue(year, 0, t -> t >= 0);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = BeanUtils.defaultValue(month, 0, t -> t >= 0);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = BeanUtils.defaultValue(day, 0, t -> t >= 0);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = BeanUtils.defaultValue(hour, 0, t -> t >= 0);
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = BeanUtils.defaultValue(minute, 0, t -> t >= 0);
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = BeanUtils.defaultValue(second, 0, t -> t >= 0);
    }

    /**
     * constructors
     */
    public TimeSpan() {

        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;

    }

    public TimeSpan(int year, int month, int day, int hour, int minute, int second) {
        setYear(year);
        setMonth(month);
        setDay(day);
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    /**
     * set current timespan over an aspect of TimeSpanParamEnum
     *
     * @param param
     * @param value
     * @throws InvalidInputException
     */
    public void set(TimeSpanParamType param, int value) throws InvalidInputException {
        if (param == null)
            throw new InvalidInputException("input can not be null");
        switch (param) {
            case YEAR: {
                setYear(value);
                break;
            }
            case MONTH: {
                setMonth(value);
                break;
            }
            case DAY: {
                setDay(value);
                break;
            }
            case HOUR: {
                setHour(value);
                break;
            }
            case MINUTE: {
                setMinute(value);
                break;
            }
            case SECOND: {
                setSecond(value);
                break;
            }
            default:
                throw new InvalidInputException("invalid input");
        }
    }

    /**
     * get total days of this
     *
     * @return
     */
    public long TotalDays() {
        return this.day;
    }

    /**
     * get total hours of this
     *
     * @return
     */
    public long TotalHours() {
        return this.day * 24 + this.hour;
    }

    /**
     * get total minutes of this
     *
     * @return
     */
    public long TotalMinutes() {
        return TotalHours() * 60 + this.minute;
    }

    /**
     * get total seconds of this
     *
     * @return
     */
    public long TotalSeconds() {
        return TotalMinutes() * 60 + this.second;
    }

    /**
     * get total milliseconds of this
     *
     * @return
     */
    public long TotalMilliSeconds() {
        return TotalSeconds() * 1000;
    }

    /**
     * valid this timespan are all positive
     *
     * @return
     */
    public boolean invalid() {
        Predicate<Integer> predicate = t -> t < 0;
        return predicate.test(year) || predicate.test(month) || predicate.test(day) || predicate.test(hour)
                || predicate.test(minute) || predicate.test(second);
    }
}
