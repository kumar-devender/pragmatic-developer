package info.pragmaticdeveloper.dsa.client.list;

import info.pragmaticdeveloper.dsa.list.StackWithLinkedList;

import java.util.Iterator;

public class StackWithLinkedListClient {
    public static void main(String[] args) {
        StackWithLinkedList<String> stack = new StackWithLinkedList<>();
        stack.push("Devender");
        stack.push("Kumar");
        Iterator<String> names = stack.iterator();
        while (names.hasNext())
            System.out.println(names.next());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
