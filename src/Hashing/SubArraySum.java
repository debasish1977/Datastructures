package Hashing;

import java.util.HashMap;

//Clarifying questions
//Both +ve & -ve integers?
//Input array can be empty?

//Approach
//I will solve this using HashMap & Prefix Sum approach

//Time Complexity: O(N)
//Space Complexity: O(N)

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0)return 0;
        HashMap<Integer,Integer> prefixFrequency = new HashMap<Integer,Integer>();
        prefixFrequency.put(0,1);
        int prefixSum = 0;
        int count = 0;
        for(int num:nums){
            prefixSum += num;
            int requiredPrefix = prefixSum - k;
            count += prefixFrequency.getOrDefault(requiredPrefix,0);
            prefixFrequency.put(prefixSum,prefixFrequency.getOrDefault(prefixSum,0)+1);

        }
        return count;
}
