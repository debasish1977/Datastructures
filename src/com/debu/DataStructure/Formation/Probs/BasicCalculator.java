package com.debu.DataStructure.Formation.Probs;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        if(s==null || s.length()==0)
        {
            return 0;
        }

        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';
        s = s.replaceAll(" ","");
        int num = 0;
        for(int i=0; i<s.length();i++)
        {
            char ch = s.charAt(i);
            //Check if its a digit
            if(Character.isDigit(ch))
            {
                num = num * 10 + (ch - '0');
            }

            if(!Character.isDigit(ch) || (i == s.length() - 1))
            {
                switch(sign)
                {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }

            }
            sign = ch;
            num = 0;
        }
        for(int val:stack)
        {
            result+=val;
        }
        return result;
    }

    public static void main(String[] args)
    {
        BasicCalculator solution = new BasicCalculator();
        String s = "3+2*2";
        System.out.println(solution.calculate(s));
    }
}
