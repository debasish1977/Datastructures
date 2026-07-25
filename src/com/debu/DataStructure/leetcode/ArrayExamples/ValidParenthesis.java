package com.debu.DataStructure.leetcode.ArrayExamples;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String str) {
        if(str==null || str.length()==0)
        {
            throw new IllegalArgumentException("Cant have any null or empty string as input");
        }
        HashMap<Character,Character> elementsMap = new HashMap<Character,Character>();
        elementsMap.put(')','(');
        elementsMap.put('}','{');
        elementsMap.put(']','[');
        Stack<Character> stackX = new Stack<Character>();
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(elementsMap.containsKey(ch))
            {
                if(stackX.isEmpty() || elementsMap.get(ch) != stackX.pop())
                {
                    return false;
                }
            }
            else {
                stackX.push(ch);
            }

        }
        return stackX.isEmpty();
    }

    public static void main(String[] args)
    {
        String str = "()";
        System.out.println("Valid Parenthesis: " + isValid(str));
    }
}
