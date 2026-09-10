package HashMap;

//Clarifying questions
//The input array can contain both +ve & -ve integers?
//Return the total number of subarrays whose sum equals to K?
//Can the input array be empty?
//Are integer sums guranteed to fit within int?

//Approach
//I will solve this using Prefix Sum + HashMap approach
//Let prefixSum be the sum from index 0 to i
//If a previous prefix sum equals equals prefixSum - k

//Time complexity: O(N)
//Space Complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        int prefixSum = 0;
        Map<Integer,Integer> prefixFreq = new HashMap<>();
        prefixFreq.put(0,1);
        int count = 0;
        for(int num:nums){
            prefixSum+=num;
            int targetPrefix = prefixSum - k;
            count += prefixFreq.getOrDefault(targetPrefix,0);
            prefixFreq.put(prefixSum,prefixFreq.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
