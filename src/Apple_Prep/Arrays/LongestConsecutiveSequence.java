package Apple_Prep.Arrays;

//Clarifying questions
//The input array contain both +ve & -ve integers?
//The input array can be empty?

//Approach
//I will first iterate through the input array and store the elements into the HashSet
//I will then check if the previous element does not exist in the HashSet
//If the previous element does not exist in the HashSet, which means this element is the beginning of a consecutive sequence
//From there I will repeatedly check num+1,num+2 and so on

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        int maxLen = 0;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        for(int element:set){
            if(!set.contains(element-1)){
                int current = element;
                int length = 1;
                while(set.contains(current+1)){
                    length++;
                    current++;
                }
                maxLen = Math.max(length,maxLen);
            }
        }
        return maxLen;
    }
}
