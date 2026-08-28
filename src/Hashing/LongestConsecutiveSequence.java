package Hashing;

//Clarifying questions
//Will the array contain both +ve & negative integers?
//Can the array be empty?
//Can nums be null or empty?
//Can the array contain duplicates?
//Do we need to return only the length or the actual sequence?
//Are we targetting O(N) expected time as required by the problem?

//Approach
//I will solve this using HashSet

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for(int num:nums){
            set.add(num);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                int current = num;
                int length = 1;
                while(set.contains(current+1)){
                    length++;
                    current++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
}
