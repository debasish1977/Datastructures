package Apple_Prep.Arrays;

//Clarifying questions
//Will the string contain lowercase english letters and digits?
//Can the string be empty?
//Need to find length of the longest substring without duplicate characters?

//Approach
//I will solve this using Sliding Window + HashMap approach

//Time complexity: O(N)
//Space Complexity: O(min(n,charset))

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)return 0;
        int maxLength = 0;
        int left = 0;
        HashMap<Character,Integer> lastSeen = new HashMap<>();
        for(int right=0;right<s.length();right++){
            char current = s.charAt(right);

            //If duplicate exists within current window
            if(lastSeen.containsKey(current) && lastSeen.get(current) >= left){
                left = lastSeen.get(current) + 1;
            }

            //Update most recent index
            lastSeen.put(current,right);

            //Update longest valid substring
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
