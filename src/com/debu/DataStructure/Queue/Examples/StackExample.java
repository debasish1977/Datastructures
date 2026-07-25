package com.debu.DataStructure.Queue.Examples;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Debu");
        stack.push("Nilu");
        stack.push("Rivi");
        System.out.println("Top:" +stack.peek());
        System.out.println("Popped:" + stack.pop());
        System.out.println("isEmpty:" +stack.isEmpty());
    }
}
