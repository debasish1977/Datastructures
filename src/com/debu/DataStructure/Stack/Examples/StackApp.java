package com.debu.DataStructure.Stack.Examples;

public class StackApp {
    public static void main(String[] args)
    {
        StackX stack = new StackX(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }
}
