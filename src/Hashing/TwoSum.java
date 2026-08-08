package Hashing;
//Clarifying questions
//The input array contains both +ve & -ve integers?
//Return exactly one solution?
//May not use the same element twice?
//Return the answer in any order?
//What should I return, if no solution exists?

//Approach
//I will solve this using hashMap & complement approach

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int complement = 0;
        HashMap<Integer,Integer> seen = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            complement = target - nums[i];
            if(seen.containsKey(complement)){
                return new int[] {seen.get(complement),i};
            }
            seen.put(nums[i],i);
        }
        return new int[0];
    }
}
