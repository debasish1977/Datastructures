package HashMap;

//Clarifying questions
//The input array can contain both +ve & -ve integers?
//Is exactly one valid pair guranteed?
//Can I assume I cannot use the same element twice?
//Each input eaxctly one solution?
//Clarifying questions
//Will the input array contain both +ve & -ve integers?
//Can the input array be empty?
//Will it contain exactly one solution?
//Return the order in any order?

//Approach
//I will solve this using HashMap & by calculating the complement
//I will iterate through the array and will calculate the complement
//If the complement exists in the map then I will return true
//Else false;

//Time complexity: O(N)
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
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
