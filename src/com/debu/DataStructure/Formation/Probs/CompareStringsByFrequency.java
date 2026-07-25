package com.debu.DataStructure.Formation.Probs;
//Compare Strings by Frequency of the Smallest Character

import java.util.Arrays;

public class CompareStringsByFrequency {
    public static void main(String[] args) {
        String[] queries = {"cbd"};
        String[] words = {"zaa","a","aaaa"};
        int[] ans = numSmallerByFrequency(queries, words);
        System.out.println(Arrays.toString(ans)); // Output: [1, 2]
    }

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordFreqs = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordFreqs[i] = f(words[i]);
        }
        Arrays.sort(wordFreqs);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int fq = f(queries[i]);
            int idx = upperBound(wordFreqs, fq);
            result[i] = wordFreqs.length - idx;
        }
        return result;
    }

    private static int f(String s) {
        char minChar = 'z';
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch < minChar) {
                minChar = ch;
                count = 1;
            } else if (ch == minChar) {
                count++;
            }
        }
        return count;
    }

    private static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
