package com.debu.DataStructure.leetcode.ArrayExamples;

public class AlternateDesignSum {
    public static int alternateDigitSum(int n) {
        int sum = 0;
        String str = String.valueOf(n);
        int sign = 1;  // start with +

        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            sum += digit * sign;
            sign *= -1;  // flip sign each step
        }

        return sum;
    }

    public static void main(String[] args)
    {
        int n = 521;
        System.out.println("Alternate Design Sum: " + alternateDigitSum(n));
    }
}
