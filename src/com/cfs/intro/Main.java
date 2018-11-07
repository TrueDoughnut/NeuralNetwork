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
     * Returns a random integer uniformly in [0, n)
     *
     * @param n number of possible integers
     * @return a random integer uniformly between 0 (inclusive) and {@code n}
     * (exclusive)
     * @throws IllegalArgumentException if {@code n <= 0}
     */
    public static int uniform(int n){
        if(n <= 0){
            throw new IllegalArgumentException("Argument must be positive: " + n);
        }
        return random.nextInt(n);
    }

    /**
     * Returns a long integer uniformly in [0, n)
     *
     * @param n number of possible {@code long} integers
     * @return a random long integer uniformly between 0 (inclusive)
     * and {@code n} (exclusive)
     * @throws IllegalArgumentException if {@code n <= 0}
     */
    public static long uniform(long n){
        if(n <= 0){
            throw new IllegalArgumentException("Argument must be positive: " + n);
        }

        long r = random.nextLong();
        long m = n - 1;

        if((n & m) == 0L){
            return r & m;
        }

        long u = r >>> 1;
        while(u + m - (r = u % n) < 0L){
            u = random.nextLong() >>> 1;
        }
        return r;
    }

    /**
     * Returns a random real number in [a, b)
     *
     * @param a the left endpoint (inclusive)
     * @param b the right endpoint (exclusive)
     * @return a random real number uniformly in [a, b)
     * @throws IllegalArgumentException if {@code a >= b}
     */
    public static double uniform(double a, double b){
        if(!(a < b)){
            throw new IllegalArgumentException("invalid range: [" + a + ", " + b + ")");
        }
        return a + uniform() * (b - a);
    }

    /**
     * @param m
     * @param n
     * @return random m by n matrix with values between 0 and 1
     */
    public static double[][] random(int m, int n){
        double[][] matrix = new double[m][n];
        for(double[] arr : matrix){
            for(int i = 0; i < arr.length; i++){
                arr[i] = uniform();
            }
        }
        return matrix;
    }

    /**
     * Transpose a matrix
     *
     * @param a matrix
     * @return matrix^T
     */
    public static double[][] T(double[][] a){
        double[][] temp = new double[a.length][a[0].length];
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[i].length; j++){
                temp[i][j] = a[i][j];
            }
        }
        return temp;
    }

    /**
     * @param a matrix
     * @param b matrix
     * @return c = a + b
     * @throws IndexOutOfBoundsException if a and b are not the same size
     * and if a and b are not rectangular
     */
    public static double[][] add(double[][] a, double[][] b){
        double[][] c = new double[a.length][a[0].length];
        for(int i = 0; i < c.length; i++){
            for(int j = 0; j < c[0].length; j++){
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    /**
     * @param a matrix
     * @param b matrix
     * @return c = a - b
     * @throws IndexOutOfBoundsException if a and b are not the same size
     * and if a and b are not rectangular
     */
    public static double[][] subtract(double[][] a, double[][] b){
        double[][] c = new double[a.length][a[0].length];
        for(int i = 0; i < c.length; i++){
            for(int j = 0; j < c[0].length; j++){
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    /**
     * Scalar subtraction
     *
     * @param a scalar
     * @param b matrix
     * @return c = b - a
     */
    public static double[][] subtract(double a, double[][] b){
        double[][] c = new double[b.length][];
        for(int i = 0; i < c.length; i++){
            c[i] = new double[b[i].length];
            for(int j = 0; j < b[i].length; j++) {
                c[i][j] = b[i][j] - a;
            }
        }
        return c;
    }

    /**
     * dot product of two matrices
     * @param a matrix
     * @param b matrix
     * @return c = a * b
     * @throws RuntimeException if columns of a does not equal rows of b
     */
    public static double[][] dot(double[][] a, double[][] b){
        if(a[0].length != b.length){
            throw new RuntimeException("Illegal matrix dimensions");
        }
        double[][] c = new double[a.length][a[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b[0].length; j++){
                for(int k = 0; k < a[0].length; k++){
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}
