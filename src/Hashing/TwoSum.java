package Hashing;
//Clarifying Questions
//Can the array contain positive, negative & duplicate values?
//Is exactly one valid solution guranteed?
//Can the same index be used more than once?
//Should I return the pair of indices in any order?

//Approach
//I will solve this HashMap and by calculating complements

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashMap;
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length < 2) return new int[0];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
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
