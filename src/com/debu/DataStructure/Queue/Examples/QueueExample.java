package com.debu.DataStructure.Queue.Examples;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Debu");
        queue.add("Nilu");
        queue.add("Ravi");
        System.out.println("Queue: " + queue);
        System.out.println("Head:" + queue.peek());
        System.out.println("Removed:"+queue.poll());
        System.out.println("Queue after poll:" +queue);
    }
}
