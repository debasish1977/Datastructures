package com.debu.DataStructure.CapitalOne;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
//Time complexity: O(n)
//Space complexity: O(n)
public class ValidParenthesis {
    public boolean isValid(String str) {
        Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch:str.toCharArray())
        {
            if(map.containsKey(ch))
            {
                stack.push(map.get(ch));
            }
            else
            {
                if(stack.isEmpty() || stack.pop() != ch)
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args)
    {
        String str = "()";
        ValidParenthesis example = new ValidParenthesis();
        boolean value = example.isValid(str);
        System.out.println(value);
    }
}
