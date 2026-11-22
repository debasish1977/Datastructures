package Arrays;

//Clarifying Questions
//The input array can be empty?
//The input array can contain both +ve & -ve integers?
//The input array is unsorted?

//Approach
//I will do this using HashSet
//I will first iterate through the input array and then put all the elements in the HashSet
//I only start counting from a number if its predecessor is absent from the HashSet.
//This guarantees that each consecutive sequence is traversed from its smallest element, avoiding redundant work.

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        HashSet<Integer> set = new HashSet<>();
        int length = 0;
        int maxLength = 0;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                length = 1;
                int current = num;
                while(set.contains(current+1)){
                    length++;
                    current++;
                }
                maxLength = Math.max(length,maxLength);
            }
        }
        return maxLength;
    }
}
