package com.debu.DataStructure.Stack.Examples;

import java.util.Stack;

public class Valid_Parenthesis {
    public boolean isValid(String s)
    {
        Stack<Character> stackX = new Stack();
        for(int i=0;i<s.length();i++)
        {
            stackX.push(s.charAt(i));
        }
        if(!stackX.empty())
        {
            char top1 = stackX.pop();
            char top2 = stackX.peek();
            if((top1 == '(' && top2 == ')') || (top1 == '{' && top2 == '}') || (top1 == '[' && top2 == ']') )
                return true;
        }
        return false;
    }
    public static void main(String[] args)
    {
        String str = "()";
        Valid_Parenthesis example = new Valid_Parenthesis();
        boolean value = example.isValid(str);
        System.out.println(value);

    }
}
