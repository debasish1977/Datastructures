package Sliding_Window;

import java.util.HashMap;

//Clarifying questions
//String consists of English letters, digits, symbols & spaces?
//Input string can be empty?

//Approach
//I will solve this using Sliding Window method
//I will have the left pointer
//I will have the right pointer
//I will iterate using right pointer & then check if the character is there in the map
//If yes, then I will increase the left pointer

//Time Complexity: O(N)
//Space Complexity: O(N)

public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)return 0;
        HashMap<Character,Integer> lastSeen = new HashMap<Character,Integer>();
        int left = 0;
        int maxLen = 0;
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            if(lastSeen.containsKey(ch))
            {
                left = Math.max(left,lastSeen.get(ch)+1);
            }
            lastSeen.put(ch,right);
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}
