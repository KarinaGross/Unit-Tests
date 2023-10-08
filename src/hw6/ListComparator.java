package hw6;

import java.util.List;

public class ListComparator {
    public static String compare(List<Integer> list1, List<Integer> list2) {
        double average1 = list1.stream().mapToInt(Integer::intValue).average().orElse(0);
        double average2 = list2.stream().mapToInt(Integer::intValue).average().orElse(0);

        if (average1 > average2) {
            return "Первый список имеет большее среднее значение";
        } else if (average1 < average2) {
            return "Второй список имеет большее среднее значение";
        } else {
            return "Средние значения равны";
        }
    }
}
