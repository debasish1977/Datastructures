//Find the maximum depth of Binary Tree
package com.debu.DataStructure.BinaryTreeExamples;

public class MaxDepthOfBinary {
   public int maxDepth(TreeNode root)
   {
       if(root == null)
           return 0;

       int leftDepth = maxDepth(root.left);
       int rightDepth = maxDepth(root.right);
       return Math.max(leftDepth,rightDepth)+1;
   }
}
