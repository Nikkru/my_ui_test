package sem_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    ArrayList arrayList = new ArrayList<>(20);

    public static void main(String[] args) {
        List<String> listName = generateNamesList();
        System.out.println(listName);
        sortByAlphabetInversionList(listName);
        System.out.println(listName);
        sortByAlphabetList(listName);
        System.out.println(listName);
        sortByLengthList(listName);
        System.out.println(listName);
        Collections.reverse(listName);
        System.out.println(listName);
    }

    private static void sortByAlphabetInversionList(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
    }

    private static void sortByAlphabetList(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    private static void sortByLengthList(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                return Integer.compare(o1.length(), o2.length());
                return o1.length() - o2.length();
            }
        });
    }

    public static List<String> generateNamesList() {
        List<String> list = new ArrayList<>();
        list.add("Николай");
        list.add("Елена");
        list.add("Мария");
        list.add("Лара");
        list.add("Иван");
        list.add("Петр");
        return list;
    }
}
