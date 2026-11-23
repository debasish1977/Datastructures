package NeetCode150.Arrays;

//Clarifying Questions
//The input array can contain both +ve & -ve integers?
//The input array can be empty?
//Every input has exactly one pair of indices

//Approach
//I will iterate through the input array and will calculate the complement
//I will then check if the complement exists in the HashMap
//If the complement exists in the HashMap, then I will return the index
//Else I will keep adding into the HashMap
//Can the array contain negative numbers, zero or duplicate values?
//Is exactly one valid solution guranteed?

//Time Complexity: O(N)
//Space Complexity: O(N)


import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return new int[0];
        }
        HashMap<Integer,Integer> seen = new HashMap<>();
        int complement = 0;
        for(int i=0;i<nums.length;i++){
            complement = target - nums[i];
            if(seen.containsKey(complement)){
                return new int[]{seen.get(complement),i};
            }
            seen.put(nums[i],i);
        }
        return new int[0];
    }
}
