package Apple_Prep.Arrays;

//Clarifying questions
//Are we guranteed exactly one valid pair?
//Must the indeces be distinct?
//Should I return if no valid pair exists?


//Approach
//I will solve this using HashMap and by calculating remainders
//I will iterate through the input array and try to calculate the remainders
//I will check if the remainders exist in the HashMap
//If the remainder exists in the HashMap, then I will return the indcies
//Else, I will keep populating in the HashMap

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length < 2)return new int[0];
        int complement = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
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
