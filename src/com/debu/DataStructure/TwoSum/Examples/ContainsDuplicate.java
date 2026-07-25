package com.debu.DataStructure.TwoSum.Examples;

import java.util.*;

public class ContainsDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length==0)
        {
            return false;
        }

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        List<Integer> indiceList = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int key = nums[i];
            if(!map.containsKey(key))
            {
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(i);
        }

        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet())
        {
            int key = entry.getKey();
            indiceList = entry.getValue();
            for(int list:indiceList)
            {
                set.add(list);
            }
            if(set.size()==2)
            {
                int diff = Math.abs(indiceList.get(0) - indiceList.get(1));
                if(diff <= k)
                {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,0,1,1};
        int k = 1;
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean result = containsDuplicate.containsNearbyDuplicate(nums,k);
        System.out.println(result);

    }
}
