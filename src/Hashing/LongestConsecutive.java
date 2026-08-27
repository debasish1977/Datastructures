package Hashing;

import java.util.HashSet;
import java.util.Set;

//Clarifying questions
//Can the input contain duplicates?
//Can the array contain negative numbers?
//Can the input be null or empty?

//Approach
//I will solve this using HashSet

//Time Complexity: O(N)
//Space Complexity: O(N)

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        Set<Integer> freqSet = new HashSet<>();
        int longest = 0;
        for(int num:nums){
            freqSet.add(num);
        }
        for(int num:freqSet)
        {
            if(!freqSet.contains(num-1)){
                int current = num;
                int length = 1;
                while(freqSet.contains(current+1)){
                    current++;
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
}
