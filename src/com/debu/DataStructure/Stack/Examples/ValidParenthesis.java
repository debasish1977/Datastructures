package com.debu.DataStructure.Stack.Examples;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s)
    {
        Stack<Character> stackX = new Stack<Character>();
        for(char ch:s.toCharArray())
        {
            if(ch == '(' || ch == '{' || ch == '[')
                stackX.push(ch);
            else
                if(stackX.empty()) return false;

                char top = stackX.pop();
                if((ch == ')' && top != '(') ||
                        (ch == '{' && top != '}') ||
                        (ch == '[' && top != ']'))
                    return false;
        }
        return stackX.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis vp = new ValidParenthesis();
        System.out.println(vp.isValid("()"));  // true
        System.out.println(vp.isValid("()[]{}"));  // true
        System.out.println(vp.isValid("(]"));  // false
        System.out.println(vp.isValid("([)]"));  // false
        System.out.println(vp.isValid("{[]}"));  // true
    }
}
