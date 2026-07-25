package com.debu.DataStructure.leetcode.Examples;

public class AlternateDigitSum {
    public static int alternateDigitSum(int n) {
        int sign = 1;
        int sum = 0;
        String str = String.valueOf(n);
        for(int i=0;i<str.length();i++)
        {
            int digit = str.charAt(i) - '0';
            sum = sum + sign*digit;
            sign = sign * -1;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        int n = 521;
        System.out.println("Alternate Digit Sum: " + alternateDigitSum(n));
    }
}
