package BinaryTree;

//Clarifying questions
//Duplicates allowed?
//Values can be Integer.MIN_VALUE/MAX_VALUE?

//Time complexity: O(N)
//Space Complexity O(h) -- recursion stack

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node,long min, long max){
        //Base case
        if(node == null){
            return true;
        }

        //Current value should be strictly inside the allowed range
        if(node.val <= min || node.val >= max){
            return false;
        }

        //Left subtree values must be < node.val
        //Right subtree values must be > node.val
        return validate(node.left,min,node.val) && validate(node.right,node.val,max);
    }
}
