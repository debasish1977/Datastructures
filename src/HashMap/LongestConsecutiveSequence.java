package HashMap;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        HashSet<Integer> elementSet = new HashSet<>();
        int maxLen = 0;
        for(int num:nums){
            elementSet.add(num);
        }
        for(int element:elementSet){
            if(!elementSet.contains(element-1)){
                int current = element;
                int length = 1;
                while(elementSet.contains(current+1)){
                    current++;
                    length++;
                }
                maxLen = Math.max(maxLen,length);
            }
        }
        return maxLen;
    }
}
