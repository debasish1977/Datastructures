package com.debu.DataStructure.neetcode.problems;

import java.util.Arrays;

//Time complexity: O(n log n + m log m) -- due to sorting
//Space complexity: O(n + m)

public class ValidAnagram {
    public boolean isAnagram(String str1, String str2) {
        char[] a = str1.toCharArray();    //O(n log n) time
        char[] b = str2.toCharArray();    //O(m log m) time
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);

    }

}
