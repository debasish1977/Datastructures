package HashMap;

//Clarifying questions
//Can I assume, there is exactly one valid pair?
//Can the same element be used more then once?
//Should I return the indices or the values?
//What should I return if no solution exists?

//Approach
//I will solve this using HashMap & by calculating complement
//I will iterate through the input array and calculate the complement
//If the complement exists in the HashMap then I will return true else will return false

//Time complexity: O(N)
//Space complexity: O(N)

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
