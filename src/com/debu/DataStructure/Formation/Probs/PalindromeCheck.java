package com.debu.DataStructure.Formation.Probs;
import java.util.Arrays;
public class PalindromeCheck {
    public boolean isValidPalindrom(String str)
    {
        if(str==null || str.length()==0)
        {
            return true;
        }
        //Orginal String
        char[] a = str.toCharArray();
        //Inverse the string
        StringBuilder strBuild = new StringBuilder(str);
        String inverseString = strBuild.reverse().toString();
        char[] b = inverseString.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }

    public static void main(String[] args)
    {
        //String str = "A man, a plan, a canal: Panama";
        String str = "race a car";
        PalindromeCheck palinDrome = new PalindromeCheck();
        System.out.println(palinDrome.isValidPalindrom(str));
    }
}
