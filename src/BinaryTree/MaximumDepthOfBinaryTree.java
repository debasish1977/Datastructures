package BinaryTree;

//Approach
//I will solve this Recursive DFS
//I will define maxDepth(node) as the maximum Depth of the subtree rooted at the node
//If the node is null, then depth is zero
//The depth of a binary tree would be 1 + maximum depth of it's left & right subtree
//If a node is none, then its depth is 0


//Time Complexity: O(n) -- every node is visited once
//Space Complexity: O(h) -- H is the height of the tree due to recursion stack
//Balanced Tree O(logn)
//Worst case: O(n)

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
