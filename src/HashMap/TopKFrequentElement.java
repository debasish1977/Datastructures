package HashMap;

//Clarifying questions
//Input array can contain both +ve & -ve integers?
//Should I return exactly the k most frequent elements?
//Can the result be returned in any order?
//Input array can be empty?
//Is k guaranteed to be valid: 1 <= k <= number of unique elements?
//Can the input array be null or empty?

//Approach
// 1. Build a frequency map: number -> frequency.
// 2. Since an element can appear at most N times, create N + 1 buckets,
//    where bucket[i] contains all elements that appear exactly i times.
// 3. Populate the buckets using the frequency map.
// 4. Traverse the buckets from highest frequency to lowest frequency
//    and collect elements until we have k elements.

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElement {
    public int[] topKFrequent(int[] nums,int k){
        if(nums==null || nums.length==0 || k<= 0)
        {
            return new int[0];
        }
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length+1];
        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        for(int i=0;i<=nums.length;i++){
            buckets[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            buckets[value].add(key);
        }

        int index = 0;
        int[] result = new int[k];
        for(int i=buckets.length - 1;i>=0 && index < k;i--){
            for(int element:buckets[i]){
                result[index++] = element;
                if(index == k){
                    break;
                }
            }
        }
        return result;
    }
}
