package com.chenghua.math;

import com.chenghua.exceptions.InvalidInputException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TinyDouble implements Serializable {

    private static final int SCALE = 2;

    public static Double add(Double input1, Double input2) throws InvalidInputException {
        if(input1 == null || input2 == null){
            throw new InvalidInputException();
        }
        return new BigDecimal(input1.toString()).add(new BigDecimal(input2.toString())).doubleValue();
    }

    public static Double minus(Double input1, Double input2) throws InvalidInputException {
        if(input1 == null || input2 == null){
            throw new InvalidInputException();
        }
        return new BigDecimal(input1.toString()).subtract(new BigDecimal(input2.toString())).doubleValue();
    }

    public static Double multiply(Double input1, Double input2) throws InvalidInputException {
        if(input1 == null || input2 == null){
            throw new InvalidInputException();
        }
        return new BigDecimal(input1.toString()).multiply(new BigDecimal(input2.toString())).doubleValue();
    }

    public static Double divide(Double input1, Double input2, Integer scale) throws InvalidInputException {
        if(scale == null){
            scale = SCALE;
        }
        if(scale < 0 || input1 == null || input2 == null){
            throw new InvalidInputException();
        }
        return new BigDecimal(input1.toString()).divide(new BigDecimal(input2.toString()),scale, RoundingMode.HALF_UP).doubleValue();
    }

    public static Double round(Double input, Integer scale) throws InvalidInputException {
        if(scale == null){
            scale = SCALE;
        }
        if(scale < 0 || input == null){
            throw new InvalidInputException();
        }
        return divide(input,1D,scale);
    }
}
