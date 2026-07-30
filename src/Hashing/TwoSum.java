package Hashing;

//Clarifying Questions
//Is exactly one valid pair guranteed?
//Should I return indices or values?
//Can the same array element be used twice?
//Can the input contain duplicate values?

//Approach
//I will solve this using HashMap & by calculating complements

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length < 2) return new int[0];
        int complement = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
