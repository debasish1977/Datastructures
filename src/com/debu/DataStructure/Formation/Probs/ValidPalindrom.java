package com.debu.DataStructure.Formation.Probs;

public class ValidPalindrom {
    public boolean isValidPalindrom(String str)
    {
        if(str==null || str.length()==0)
        {
            return true;
        }
        //Take two pointer approach
        int left = 0;
        int right = str.length() - 1;
        while(left < right)
        {
            //Move the left pointer
            while(left < right && !Character.isLetterOrDigit(str.charAt(left)))
            {
                left ++;
            }
            //Move the right pointer until Alphanumeric
            while(left < right && !Character.isLetterOrDigit(str.charAt(right)))
            {
                right --;
            }
            if(Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right)))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args)
    {
        ValidPalindrom solution = new ValidPalindrom();
        String str = "race a car";
        System.out.println(solution.isValidPalindrom(str));
    }
}
