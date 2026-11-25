package COMPANY_WISE_PROBLEMS.WALMART.ARRAYS;

//Clarifying questions
//The input array can be empty?
//The input array can contain both +ve & -ve integers?
//I can return the answer in any order?
//Is the answer guranteed to be unique?
//What is the maximum input size and should I optimize for time or memory?

//Approach
//I will first count the frequency of each number using HashMap
//Since no element can appear more then N times, I will create N+1 frequency buckets
//Each bucket stores the elements appearing that many times
//I will then traverse the buckets from highest frequency to lowest collecting until I have K results
//This avoids sorting
//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length==0)return new int[0];
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        //Build frequency map
        for(int i=0;i<nums.length;i++){
            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
        }
        //Create frequency buckets
        //buckets[i] contains numbers appearing i times
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for(int i=0;i<buckets.length;i++){
            buckets[i]=new ArrayList<>();
        }
        //Step 3: Group elements by frequency
        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()){
            int num = entry.getKey();
            int frquency = entry.getValue();
            buckets[frquency].add(num);
        }

        int[] result = new int[k];
        int index = 0;
        for(int i=buckets.length-1;i>=1;i--){
            for(int num:buckets[i]){
                result[index++] = num;
                if(index==k){
                    return result;
                }
            }

        }
        return result;
    }
}
