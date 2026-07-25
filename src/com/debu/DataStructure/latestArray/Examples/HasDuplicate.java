package com.debu.DataStructure.latestArray.Examples;

import java.util.HashSet;

public class HasDuplicate {
    public boolean hasDuplicate(int[] nums)
    {
        HashSet<Integer> elementSet = new HashSet<Integer>();
        for(int num:nums)
        {
            if(!elementSet.add(num))
            {
                return true;
            }

        }
        return false;
    }
}
