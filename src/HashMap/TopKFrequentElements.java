package HashMap;
//Clarifying questions
//Input array can contain both +ve & -ve integers?
//Return k most frequent elements?
//Return the answer in any order?
//Input array can be empty?

//Approach
//I will use HashMap & a bucket sort approach

//Time Complexity: O(N)
//Space Complexity: O(N)

//Top K Frequent Elements:  https://leetcode.com/problems/top-k-frequent-elements/?envType=company&envId=amazon&favoriteSlug=amazon-thirty-days

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums,int k){
        if(nums==null || nums.length ==0 || k <= 0)return new int[0];
        List<Integer>[] buckets = new List[nums.length+1];
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0;i<=nums.length;i++){
            buckets[i] = new ArrayList<>();
        }

        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }


        for(Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            buckets[value].add(key);
        }

        int[] result = new int[k];
        int index = 0;
        for(int i=nums.length;i >= 1 && index < k;i--){
            for(int val:buckets[i]){
                result[index++]=val;
                if(index==k){
                    break;
                }
            }
        }
        return result;

    }
}
