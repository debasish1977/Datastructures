package HashMap;

//Clarifying questions
//Can nums contain negative numbers?
//Can nums contain zero?
//Do we need the actual subarrays or just the count?
//Are subarrays required to be contigous?
//Can K be negative?

//Approach
//I will solve this using Prefix Sum + HashMap approach
//Let prefixSum be the sum from index 0 to i
//If a previous prefix sum equals equals prefixSum - k

//Time complexity: O(N)
//Space Complexity: O(N)

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0)return 0;
        HashMap<Integer,Integer> prefixCount = new HashMap<>();
        prefixCount.put(0,1);
        int prefixSum = 0;
        int count = 0;
        int currentSum = 0;
        for(int num:nums){
            currentSum += num;
            count+=prefixCount.getOrDefault(currentSum - k,0);
            prefixCount.put(currentSum,prefixCount.getOrDefault(currentSum,0)+1);
        }
        return count;
    }
}
