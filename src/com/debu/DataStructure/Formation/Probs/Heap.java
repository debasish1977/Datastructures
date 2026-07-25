package com.debu.DataStructure.Formation.Probs;

public class Heap {
    private int[] heap;
    private int size;

    public Heap(int capacity)
    {
        heap = new int[capacity];
    }

    public boolean isFull()
    {
        return size == heap.length;
    }

    public int getParent(int index)
    {
        return (index-1)/2;
    }

    private void fixHeapAbove(int index)
    {
        int newValue = heap[index];
        while(index > 0 && newValue > heap[getParent(index)])
        {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
    }
}
