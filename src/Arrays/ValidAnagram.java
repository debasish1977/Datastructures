package Arrays;

//Clarifying Questions
//Both strings contains only characters?
//Can the strings be empty?

//Approach
//I will convert both the Strings into character arrays
//Then I will compare both the character arrays & check if they both match

//Space Complexity: O(NlogN)
//Time Complexity: O(N)

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null) return (s==t);
        if(s.length() != t.length()) return false;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
    }
}
