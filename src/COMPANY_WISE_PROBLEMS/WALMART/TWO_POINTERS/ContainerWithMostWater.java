package COMPANY_WISE_PROBLEMS.WALMART.TWO_POINTERS;

//Clarifying questions
//Does the input contain only non negative integers?
//Can the input contain fewer then two elements?
//Can the container be titled?
//What are the maximum input size and constraints?
//Do we need to return the maxArea or the indices of the two lines?

//Approach
//I will initialize two pointers at opposite ends to maximize the initial width. At every iteration,
// I calculate the area and move the shorter boundary inward. Keeping the shorter boundary while reducing the width cannot improve the current area,
// so those candidate pairs can safely be eliminated.
//This gives us a linear-time solution with constant auxiliary space.

//Time Complexity: O(N)
//Space Complexity: O(1)

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height==null || height.length==0)return 0;
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int width = right - left;
            int ht = Math.min(height[right],height[left]);
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
