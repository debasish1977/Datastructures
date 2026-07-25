package com.debu.DataStructure.Stack.Examples;

public class StackY {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackY(int size)
    {
       this.maxSize = size;
       stackArray = new int[size];
       top = -1;
    }

    public void push(int j)
    {
        stackArray[++top] = j;
    }

    public int peek()
    {
        return stackArray[top];
    }

    public int pop()
    {
        return stackArray[top--];
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }

    public boolean isFull()
    {
        return (top == this.maxSize-1);
    }

    public static void main(String[] args)
    {
        StackY stack = new StackY(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        while(!stack.isEmpty())
        {
            int value = stack.pop();
            System.out.println(value);
        }
    }
}
