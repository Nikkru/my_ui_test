package sem_4;

import java.util.*;

public class Task2 {

    public static void main(String[] args) {
        List<String> namesList = generateNamesList();
        System.out.println(namesList);
        Set<String> namesSet = new HashSet<>(namesList);
        System.out.println(namesSet);
        getMaxByAlphabet(namesSet);
        System.out.println(getMinByAlphabet(namesSet));
//        System.out.println(getMinByAlphabet_(namesList));
        removeChar(namesSet, "А");
        System.out.println(namesSet);
    }

    static String getMaxByAlphabet(Set<String> set) {
//        Set<String> set1 = new TreeSet<>(set);
        System.out.println(set.stream().max((s1, s2) -> s1.length() - s2.length()).get());
        return null;
    }

    static String getMinByAlphabet(Set<String> set) {
        Set<String> set1 = new TreeSet<>(set);
            return String.valueOf(set1.stream().min(String::compareTo).get());
    }

    static void removeChar(Set<String> set, String character) {
        set.removeIf(s -> s.contains(character));
    }

//    static <T extends Collection> T getMinByAlphabet_(T t) {
//        T t1 = (T) new TreeSet<>(t);
//        t1.iterator().next();
//        /*
//         return t1.stream().min(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//         */
//        Iterator<T> iterator = t1.iterator();
//        if (iterator.hasNext()) {
//           return iterator.next();
//        }
//        return null;
//    }

     static List<String> generateNamesList() {
        List<String> list = new ArrayList<>();
        list.add("Николай");
        list.add("Елена");
        list.add("Анастасия");
        list.add("Елена");
        list.add("Мария");
        list.add("Александр");
        list.add("Лара");
        list.add("Иван");
        list.add("Иван");
        list.add("Петр");
        list.add("Саша");
        list.add("Розамария");
        return list;
    }
}
