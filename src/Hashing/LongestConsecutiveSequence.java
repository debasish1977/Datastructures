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

public class LongestConsecutiveSequence {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[0];
        HashMap<Integer,Integer> freqMap = new HashMap<Integer,Integer>();
        int complement = 0;
        for(int i=0;i<nums.length;i++){
            complement = target - nums[i];
            if(freqMap.containsKey(complement)){
                return new int[] {freqMap.get(complement),i};
            }
            freqMap.put(nums[i],i);
        }
        return new int[0];
    }
}
