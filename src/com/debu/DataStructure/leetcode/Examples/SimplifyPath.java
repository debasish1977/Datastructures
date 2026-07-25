package com.debu.DataStructure.leetcode.Examples;

import java.util.Stack;

public class SimplifyPath
{
    public static String simplifyPath(String path) {
        if(path==null || path.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder();
        String[] parts = path.split("/");
        Stack<String> stackX = new Stack();
        for(String part:parts)
        {
            if(part.equals("") || part.equals(".."))
                continue;
            if(part.equals(".."))
            {
                if(!stackX.isEmpty())
                {
                    stackX.pop();
                }
            }
            else
            {
                stackX.push(part);
            }
        }
        for(String dir:stackX)
        {
            sb.append("/").append(dir);
        }
        return sb.length() > 0 ? sb.toString() : "/";

    }

    public static void main(String[] args)
    {
        String path = "/home//foo/";
        System.out.println("Simplify Path: " + simplifyPath(path));
    }
}
