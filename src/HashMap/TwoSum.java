package HashMap;

//Clarifying questions
//The input array can contain both +ve & -ve integers?
//Is exactly one valid pair guranteed?
//Can I assume I cannot use the same element twice?
//Each input eaxctly one solution?
//Return the answer in any order?
//Input array can be empty?
//Should I return the answer in any order?

//Approach
//I will solve this using HashMap & by calculating complement
//I will iterate through the HashMap & try to calculate the complement

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0)return new int[0];
        int complement = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
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
