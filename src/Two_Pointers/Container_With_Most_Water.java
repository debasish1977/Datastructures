//Clarifying Questions
//Can the input be null or contain fewer than two elements?
//Are all heights non-negative integers?
//Should I return the maximum area rather than the two indices?
//Are there constraints large enough that integer overflow is possible?

//Approach
//I will use two pointers, initially placed at the two ends of the array. The area is determined by the distance between the
//pointers and the shorter of the two heights. After calculating the current area, I move the pointer with the
//shorter height inward. Moving the taller pointer cannot improve the area because the width decreases while the
//shorter height still limits the container. This allows us to eliminate one candidate on every iteration.

//Time Complexity: O(N)
//Space Complexity: O(N)


class Solution {
    public int maxArea(int[] height) {
        if(height==null || height.length < 2)
        {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int ht = Math.min(height[left],height[right]);
            int width = right - left;
            int area = ht*width;
            maxArea = Math.max(maxArea,area);
            if(height[left]<height[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;
    }
}