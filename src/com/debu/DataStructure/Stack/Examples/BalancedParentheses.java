package com.debu.DataStructure.Stack.Examples;

import java.util.Stack;

public class BalancedParentheses {
    public static boolean isBalanced(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(ch == '(')
                stack.push(ch);
            else if(ch == ')')
            {
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args)
    {
        System.out.println(isBalanced("(a+b)*(c+d)"));
    }
}
