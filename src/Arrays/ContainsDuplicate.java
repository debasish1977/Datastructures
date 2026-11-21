package Arrays;

//Clarifying Questions
//The input array will contain both +ve & -ve integers?
//Can the input array be null or empty?
//Can the array contains negative numbers or zero?
//Am I allowed to modify the input array?

//Approach
//I will iterate through the input array and check if the element contains in the the HashSet
//If yes then input array contains duplicate else no duplicate

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        if(nums==null || nums.length==0)return false;
        HashSet<Integer> seen = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(seen.contains(nums[i])){
                return true;
            }
            seen.add(nums[i]);
        }
        return false;
    }
}
