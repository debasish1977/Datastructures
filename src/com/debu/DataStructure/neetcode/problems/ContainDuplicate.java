package com.debu.DataStructure.neetcode.problems;

//Time complexity: O(n) -- Since each insertion and lookup in HashSet is O(1) on average repeated for n elements.
//Space complexity: O(n) -- In the worst case(no duplicates), HashSet will store all the elements.
import java.util.HashSet;

public class ContainDuplicate {
    public boolean containDuplicate(int[] nums)
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
