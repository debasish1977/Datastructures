package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    public TreeNode invertTree(TreeNode root)
    {
        //Edge case
        if(root==null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //Using BFS
//    public TreeNode invertTree(TreeNode root){
//        if(root==null){
//            return null;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            TreeNode node = queue.poll();
//            TreeNode temp = node.left;
//            node.left = node.right;
//            node.right = temp;
//            if(node.left!=null){
//                queue.offer(node.left);
//            }
//            if(node.right!=null){
//                queue.offer(node.right);
//            }
//        }
//        return root;
//    }
}
