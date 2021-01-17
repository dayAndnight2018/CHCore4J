package com.chenghua.datetime;
import com.chenghua.exceptions.InvalidInputException;

/**
 * DateTime formatter Enum
 */
public enum DateFormatPattern {

    SHORT_DATE("yyyy/MM"),
    LONG_DATE("yyyy/MM/dd"),
    SHORT_TIME("HH:mm"),
    LONG_TIME("HH:mm:ss"),
    DATE_TIME("yyyy/MM/dd HH:mm:ss"),
    TEXT_SHORT_DATE("yyyy年MM月"),
    TEXT_LONG_DATE("yyyy年MM月dd日"),
    FULL_TEXT_DATE_TIME("yyyy年MM月dd日 HH:mm:ss");

    /**
     * pattern
     */
    private String pattern;
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    public String getPattern(){
        return this.pattern;
    }

    /**
     * constructor
     * @param pattern
     */
    DateFormatPattern(String pattern){
        this.pattern = pattern;
    }

    /**
     * parse DateTime formatter from String to enum
     * @param pattern
     * @return
     * @throws InvalidInputException
     */
    DateFormatPattern parsePattern(String pattern) throws InvalidInputException {
        DateFormatPattern result = null;
        if(pattern == null || pattern.trim().length() == 0){
            throw new InvalidInputException();
        }

        for(DateFormatPattern p : DateFormatPattern.values()){
            if(p.getPattern().equals(pattern)){
                result = p;
                break;
            }
        }
        return  result;
    }
}
