package com.chenghua.random;
import com.chenghua.exceptions.InvalidInputException;

import java.security.SecureRandom;

public class Random {

    private static final double PRECISE = 0.0000000001;

    /**
     * random a int value between min and max
     *
     * @param min
     * @param max
     * @return
     * @throws InvalidInputException
     */
    public static int randInt(int min, int max) throws InvalidInputException {
        if (min >= max) {
            throw new InvalidInputException();
        }
        SecureRandom random = new SecureRandom();
        return min + random.nextInt(max - min + 1);
    }

    /**
     * random a int value between 0 and max
     *
     * @param max
     * @return
     * @throws InvalidInputException
     */
    public static int randInt(int max) throws InvalidInputException {
        return randInt(0, max);
    }

    /**
     * random a double value between min and max
     *
     * @param min
     * @param max
     * @return
     * @throws InvalidInputException
     */
    public static double randDouble(double min, double max) throws InvalidInputException {
        if (min > max || max - min < PRECISE) {
            throw new InvalidInputException();
        }
        SecureRandom random = new SecureRandom();
        return min + random.nextDouble() * (max - min);
    }

    /**
     * random a double value between 0 and max
     *
     * @param max
     * @return
     * @throws InvalidInputException
     */
    public static double randDouble(double max) throws InvalidInputException {
        return randDouble(0, max);
    }

    /**
     * random a long value between min and max
     *
     * @param min
     * @param max
     * @return
     * @throws InvalidInputException
     */
    public static long randLong(long min, long max) throws InvalidInputException {
        if (min >= max) {
            throw new InvalidInputException();
        }
        SecureRandom random = new SecureRandom();
        return min + (long) (random.nextDouble() * (max - min));
    }

    /**
     * random a long value between min and max
     *
     * @param max
     * @return
     * @throws InvalidInputException
     */
    public static long randLong(long max) throws InvalidInputException {
        return randLong(0, max);
    }

    /**
     * random a float value between min and max
     *
     * @param min
     * @param max
     * @return
     * @throws InvalidInputException
     */
    public static float randFloat(float min, float max) throws InvalidInputException {
        if (min > max || max - min < PRECISE) {
            throw new InvalidInputException();
        }
        SecureRandom random = new SecureRandom();
        return min + (float) (random.nextDouble() * (max - min));
    }

    /**
     * random a float value between 0 and max
     *
     * @param max
     * @return
     * @throws InvalidInputException
     */
    public static float randFloat(float max) throws InvalidInputException {
        return randFloat(0, max);
    }
}
