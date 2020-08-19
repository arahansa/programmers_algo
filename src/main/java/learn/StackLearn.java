package learn;

import java.util.Stack;

public class StackLearn {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);

        System.out.println(stack);
        Integer peek = stack.peek();
        System.out.println("peek :"+peek);

        System.out.println(stack);
        Integer pop = stack.pop();
        System.out.println("pop :"+pop);
        System.out.println(stack);
    }
}
