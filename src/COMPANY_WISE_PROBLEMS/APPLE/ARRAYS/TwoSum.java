package COMPANY_WISE_PROBLEMS.APPLE.ARRAYS;
//Clarifying Questions
//The input array contains both +ve & -ve integers?
//Each input have exactly one solution?
//Can the same element be used twice?
//Can the input array be empty?

//Approach
//I will iterate through the input array and calculate the complements
//Then I will check if the complement exists in the HashMap
//If the complement exists then I will return the indices else I will update the HashMap

//Time Complexity: O(N)
//Space Complexity: O(N)

//Two Sum -- https://leetcode.com/problems/two-sum/submissions/2197050545/?envType=company&envId=apple&favoriteSlug=apple-all

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length ==0)return new int[0];
        int complement = 0;
        HashMap<Integer,Integer> seen = new HashMap<>();
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
