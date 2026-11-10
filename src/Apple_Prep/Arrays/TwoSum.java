package Apple_Prep.Arrays;
//Clarifying Questions
//Can the array contains negative numbers, zero & duplicates?
//Is exactly one valid solution guranteed?
//Can the array be empty or null?
//The input array contains both +ve & -ve integers
//The input array can be empty or null?
//Exactly one solution?

//Approach
//I will iterate through the input elements and try to find the complement
//If the complement exists in the HashMap, then I will return the index
//Else, I will keep updating the HashMap

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
