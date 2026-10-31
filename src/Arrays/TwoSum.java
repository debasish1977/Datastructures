package Arrays;
//URL: https://leetcode.com/problems/two-sum/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
//URL: https://leetcode.com/problems/two-sum/submissions/2179598695/?envType=company&envId=apple&favoriteSlug=apple-all

//Clarifying questions
//Input array can contain both +ve & -ve integers?
//Input array can be empty?
//Is exactly one valid solution guranteed?
//Can the array contain duplicate values?
//Can I use the same elements twice?
//Should I return indices or values?

//Approach
//I will use a one pass HashMap to store each previously visited number and its index.
//For every element, I will calculate the complement required to reach the target
//If the complement exists in the HashMap, I will return the stored index and the current index
//Otherwise I will use the current element to HashMap
//By checking before inserting, I will make sure I will not use the same element twice

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0)return new int[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        int complement = 0;
        for(int i=0;i<nums.length;i++){
            complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
