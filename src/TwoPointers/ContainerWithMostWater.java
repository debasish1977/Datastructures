package TwoPointers;

//Clarifying Questions
//All the heights are non negative integers?
//Should I return the maximum area that can be formed by any two lines?
//Can the input be null or fewer then two elements?

//Approach
//I will use a two-pointer approach
//Start with left --> first element
//right --> last element
//For every pair
//width = right - left
//height = min(height[right],height[left])
//area = width * height
//So, if height[left] < height[right], move left
//otherwise move right

//Time Complexity: O(N)
//Space Complexity: O(1)

//Container with Most water:https://leetcode.com/problems/container-with-most-water/description/?envType=company&envId=amazon&favoriteSlug=amazon-thirty-days

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height==null || height.length < 2)return 0;
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int ht = Math.min(height[right],height[left]);
            int width = right - left;
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
