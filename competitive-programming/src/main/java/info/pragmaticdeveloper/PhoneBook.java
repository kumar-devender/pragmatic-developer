package info.pragmaticdeveloper;

import java.util.*;

public class PhoneBook {
    private static Map<String, String> phoneBook = new HashMap<>();
    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        int inputCount = reader.nextInt();
        reader.nextLine();
        for (int i = 0; i < inputCount; i++) {
            String contactNumber = reader.nextLine();
            String[] dict = contactNumber.split(" ");
            phoneBook.put(dict[0], dict[1]);
        }
        while (reader.hasNext()) {
            String name = reader.nextLine();
            String number = phoneBook.get(name);
            String output = number == null ? "Not found" : name + "=" + number;
            System.out.println(output);
        }
    }
}
