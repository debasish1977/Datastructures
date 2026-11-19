package COMPANY_WISE_PROBLEMS.WALMART;

//Clarifying Questions
//The input array can be both +ve & -ve?
//The input array can be empty?
//I need to return the longest consecutive element sequence?

//Approach
//I will do this using HashSet Approach
//First I will iterate through the input array and populate all the elements into the HashSet
//I will then iterate through the HashSet and check if the previous element is not there
//If not then I will increase the count

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        HashSet<Integer> seen = new HashSet<>();
        int maxLen = 0;
        int length = 0;
        for(int i=0;i<nums.length;i++){
            seen.add(nums[i]);
        }
        for(int num:seen){
            int current = num;
            if(!seen.contains(current - 1)){
                length = 1;
                while(seen.contains(current+1)){
                    current++;
                    length++;
                }
            }
            maxLen = Math.max(maxLen,length);
        }
        return maxLen;
    }
}
