package com.debu.DataStructure.Stack.Examples;

public class StackZ {
    private int maxSize;
    private int[] maxArray;
    private int top;

    public StackZ(int size)
    {
        this.maxSize = size;
        maxArray = new int[this.maxSize];
        top = -1;
    }

    public void push(int element)
    {
        maxArray[++top] = element;
    }

    public int peek()
    {
        return maxArray[top--];
    }

    public int pop()
    {
        return maxArray[top--];
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }

    public boolean isFull()
    {
        return (top == maxSize - 1);
    }

    public static void main(String[] args)
    {
        int value = 0;
        StackZ stack = new StackZ(5);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        while(!stack.isEmpty())
        {
            value = stack.pop();
            System.out.println("Value-->"+value);
        }

    }

}
