//Balanced Tree Or Not
//https://www.geeksforgeeks.org/dsa/how-to-determine-if-a-binary-tree-is-balanced/

package com.debu.DataStructure.BTreeLeetCodeExamples;

public class IsBalancedTreed {
    static int height(TreeNode root)
    {
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }

    public boolean isBalanced(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
}
