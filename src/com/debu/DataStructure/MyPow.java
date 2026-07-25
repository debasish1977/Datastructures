package com.debu.DataStructure;

public class MyPow {
    public static double myPow(double x, int n) {
        long power = n; // use long to handle overflow when n = Integer.MIN_VALUE

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1.0;
        while (power > 0) {
            if ((power % 2) == 1) { // if power is odd
                result *= x;
            }
            x *= x;       // square the base
            power /= 2;   // halve the exponent
        }

        return result;
    }


    public static void main(String[] args) {
        // Test cases
        double x1 = 2.0;
        int n1 = 10;
        System.out.println("myPow(" + x1 + ", " + n1 + ") = " + myPow(x1, n1)); // 1024.0

        double x2 = 2.1;
        int n2 = 3;
        System.out.println("myPow(" + x2 + ", " + n2 + ") = " + myPow(x2, n2)); // 9.261

        double x3 = 2.0;
        int n3 = -2;
        System.out.println("myPow(" + x3 + ", " + n3 + ") = " + myPow(x3, n3)); // 0.25

        double x4 = 3.0;
        int n4 = 0;
        System.out.println("myPow(" + x4 + ", " + n4 + ") = " + myPow(x4, n4)); // 1.0
    }

}
