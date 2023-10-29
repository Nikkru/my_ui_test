package sem_4;

import java.util.HashMap;
import java.util.Map;

public class Task3 {

    public static void main(String[] args) {
        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("1230", "Nikolai");
        phonebook.put("124", "Tatiana");
        phonebook.put("12500", "Vsevolod");
        phonebook.put("126", "Vladimir");
        phonebook.put("127", "Alexandr");
        phonebook.put("13289", "Klara");
        phonebook.put("120", "Mari");

        System.out.println(
                phonebook.entrySet().stream().min((e1, e2) -> e1.getKey().compareTo(e2.getKey())).get());
        System.out.println(
                phonebook.entrySet().stream().max((e1, e2) -> e1.getValue().compareTo(e2.getValue())).get().getKey());
    }

}
