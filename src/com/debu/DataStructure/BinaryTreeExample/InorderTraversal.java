package com.debu.DataStructure.BinaryTreeExample;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();
        inorderHelper(root,result);
        return result;
    }

    private void inorderHelper(TreeNode root, List<Integer> result)
    {
        if(root == null) return;
        inorderHelper(root.left,result);
        result.add(root.val);
        inorderHelper(root.right,result);
    }
}
