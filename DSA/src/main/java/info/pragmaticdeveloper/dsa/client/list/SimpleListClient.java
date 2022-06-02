package info.pragmaticdeveloper.dsa.client.list;

import info.pragmaticdeveloper.dsa.list.SimpleList;

import java.util.Iterator;

public class SimpleListClient {
    public static void main(String[] args) {
        SimpleList<String> list = new SimpleList<>();
        list.insertAtBeginning("Devender");
        list.insertAtBeginning("Kumar");
        list.insertAtBeginning("Yadav");
        Iterator<String> names = list.iterator();
        while (names.hasNext()) {
            System.out.println(names.next());
        }

        System.out.println("Size : " + list.size());
        names = list.iterator();
        list.insertAtEnd("Devender");
        list.insertAtEnd("Kumar");
        list.insertAtEnd("Yadav");

        System.out.println("Size : " + list.size());

        while (names.hasNext()) {
            System.out.println(names.next());
        }
    }
}
