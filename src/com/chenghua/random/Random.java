package com.chenghua.random;

import com.chenghua.exceptions.InvalidInputException;

public class Random {

    public static final double PRECISE = 0.0000000001;

    public static int randInt(int min, int max) throws InvalidInputException {
        if (min >= max) {
            throw new InvalidInputException();
        }
        java.util.Random random = new java.util.Random();
        return min + random.nextInt(max - min);
    }

    public static double randDouble(double min, double max) throws InvalidInputException {
        if (min > max || max - min < PRECISE) {
            throw new InvalidInputException();
        }
        java.util.Random random = new java.util.Random();
        return min + random.nextDouble() * (max - min);
    }

    public static long randLong(long min, long max) throws InvalidInputException {
        if (min >= max) {
            throw new InvalidInputException();
        }
        java.util.Random random = new java.util.Random();
        return min + (long) (random.nextDouble() * (max - min));
    }

    public static float randFloat(float min, float max) throws InvalidInputException {
        if (min > max || max - min < PRECISE) {
            throw new InvalidInputException();
        }
        java.util.Random random = new java.util.Random();
        return min + (float) (random.nextDouble() * (max - min));
    }
}
