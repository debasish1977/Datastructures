package com.debu.DataStructure.latestArray.Examples;

public class IsPalindrome {
    public boolean isPalinDrome(int x)
    {
        String numberString = Long.toString(x);
        String cleanedString = numberString.replaceAll("[^0-9]", "");
        StringBuilder strBuilder = new StringBuilder(cleanedString);
        strBuilder.reverse();
        Long reverseString = Long.parseLong(strBuilder.toString());
        return x == reverseString;
    }
}
