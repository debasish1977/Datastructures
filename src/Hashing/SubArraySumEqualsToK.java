package Hashing;

//Clarifying questions
//Can nums contain positive, negative & zero values?
//Can the input array be null or empty?
//Do we need to count of subarrays and not the actual subarrays

//Approach
//I will maintain a running prefix sum
//If the current prefix sum is S, then a previous prefix sum of S-k
//means the elements between those two positions sum to k
//I will maintain a HashMap from prefixSum to the number of times we have previously seen

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashMap;

public class SubArraySumEqualsToK {
    public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;

        //prefixSum -- number of times we have seen it
        HashMap<Integer,Integer> prefixMap = new HashMap<>();
        prefixMap.put(0,1);
        int prefixSum = 0;
        int count = 0;

        for(int num:nums){
            prefixSum += num;
            int target = prefixSum - k;
            if(prefixMap.containsKey(target)){
                count += prefixMap.get(target);
            }
            prefixMap.put(prefixSum,prefixMap.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
