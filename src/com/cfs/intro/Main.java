package com.cfs.intro;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static Random random;
    private static long seed;

    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    /**
     * Sets the seed of the number generator
     * Allows for same sequence of "random" numbers
     *
     * @param s the new seed
     */
    public static void setSeed(long s){
        seed = s;
        random = new Random(seed);
    }

    /**
     * Returns the seed of the random number generator
     *
     * @return the seed of the random number generator
     */
    public static long getSeed(){
        return seed;
    }

    /**
     * Returns a random integer uniformly in interval [0, 1)
     *
     * @return a random integer uniformly in [0, 1)
     */
    public static double uniform(){
        return random.nextDouble();
    }

    /**
     *
     * @param n
     * @return
     */
    public static int uniform(int n){
        if(n <= 0){
            throw new IllegalArgumentException("Argument must be positive: " + n);
        }
    }
}
