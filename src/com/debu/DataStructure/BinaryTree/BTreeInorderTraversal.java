package com.debu.DataStructure.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BTreeInorderTraversal {

    public List<Integer> inorderTraversal(BTreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();
        inorderHelper(root,result);
        return result;
    }

    private void inorderHelper(BTreeNode node, List<Integer> result)
    {
        if(node==null) return;
        inorderHelper(node.left,result);
        result.add(node.val);
        inorderHelper(node.right,result);
    }

}
