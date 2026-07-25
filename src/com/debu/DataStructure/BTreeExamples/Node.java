package com.debu.DataStructure.BTreeExamples;

public class Node {
   int data;
   Node left;
   Node right;

   Node(int v)
   {
       this.data = v;
       this.left = null;
       this.right = null;
   }
}
