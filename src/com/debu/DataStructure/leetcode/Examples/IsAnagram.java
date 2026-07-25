package com.debu.DataStructure.leetcode.Examples;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        int[] count = new int[26]; // assuming lowercase letters
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        String s = "anagram";
        String t = "nagaram";
        IsAnagram isAnagram = new IsAnagram();
        boolean output = isAnagram.isAnagram(s,t);
        System.out.println(output);
    }

}
