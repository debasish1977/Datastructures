package Sliding_Window;

//Clarifying questions
//Can the array be null or fewer then two elements?
//Are heights non negative integers?
//Should I return 0 when no container can be formed?
//Can the calculated area exceed the integer range?

//Approach
//I will start with the widest possible container using the first and last lines.
//The area is constrained by the shorter of the
//two heights. Moving the taller line cannot improve the area because the
//width decreases while the limiting height cannot
//increase. Therefore, I move the shorter pointer inward, which is the only move
//that may discover a taller limiting boundary.

//Time Complexity: O(N)
//Space Complexity: O(1)

public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        if(height==null || height.length==0) return 0;
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int width = right - left;
            int ht = Math.min(height[left],height[right]);
            int area = width * ht;
            maxArea = Math.max(area,maxArea);
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}
