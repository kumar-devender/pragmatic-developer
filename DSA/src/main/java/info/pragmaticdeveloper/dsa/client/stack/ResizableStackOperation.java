package info.pragmaticdeveloper.dsa.client.stack;

import info.pragmaticdeveloper.dsa.stack.ResizingArrayStack;

import java.util.Iterator;

public class ResizableStackOperation {
    public static void main(String[] args) {
        ResizingArrayStack<String> names = new ResizingArrayStack<>();
        names.push("Devender");
        System.out.println("Size : " + names.size());
        names.push("Kumar");
        System.out.println("Size : " + names.size());
        names.push("Yadav");
        System.out.println("Size : " + names.size());
        Iterator<String> reverseOrderNameIterator = names.iterator();
        while (reverseOrderNameIterator.hasNext()) {
            System.out.println(reverseOrderNameIterator.next());
        }
        names.pop();
        reverseOrderNameIterator = names.iterator();
        while (reverseOrderNameIterator.hasNext()) {
            System.out.println(reverseOrderNameIterator.next());
        }
        names.pop();
        names.pop();
        System.out.println("Empty : " + names.isEmpty());
    }
}
