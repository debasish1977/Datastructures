package Apple_Prep.Arrays;

//Clarifying questions
//The input element can contain both -ve & +ve integers
//The input array can be empty?
//Can k be negative or zero?
//Are we counting all valid subarrays or returning their indices?

//Approach
//I will solve this using prefix sum & Hashing technique
//I will first iterate through the input array & check if the target sum -k is available in the HashSet

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashMap;

public class Subarray_Sum_EqualsK {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;
        if(nums==null || nums.length==0)return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num:nums){
            prefixSum += num;
            int complement = prefixSum - k;
            count += map.getOrDefault(complement,0);
            map.put(prefixSum,map.getOrDefault(prefixSum,0) + 1);
        }
        return count;
    }
}
