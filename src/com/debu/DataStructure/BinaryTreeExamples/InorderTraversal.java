package com.debu.DataStructure.BinaryTreeExamples;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();
        inorderHelper(root,result);
        return result;
    }
    private void inorderHelper(TreeNode node, List<Integer> result)
    {
        if(node==null) return;
        inorderHelper(node.left,result);
        result.add(node.val);
        inorderHelper(node.right,result);
    }
}
