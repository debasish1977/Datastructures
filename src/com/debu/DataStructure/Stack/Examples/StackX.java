package com.debu.DataStructure.Stack.Examples;

public class StackX {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackX(int size)
    {
        this.maxSize = size;
        stackArray = new int[this.maxSize];
        top = -1;
    }

    public void push(int j)
    {
        stackArray[++top] = j;
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
        return (top == this.maxSize - 1);
    }

}
