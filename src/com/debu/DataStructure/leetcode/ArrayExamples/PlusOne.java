package com.debu.DataStructure.leetcode.ArrayExamples;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        // traverse from rightmost digit
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;   // just increment and return
                return digits;
            }
            digits[i] = 0;     // carry over
        }

        // if all digits were 9 (e.g. 999 -> 1000)
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args)
    {
        int[] digits = {9};
        System.out.println("Plus One: " + plusOne(digits));
    }
}
