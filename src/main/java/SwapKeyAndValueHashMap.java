/*
Реализуй метод, который поменяет ключи и значения HashMap местами
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SwapKeyAndValueHashMap {

    public static void main(String[] args) {
        HashMap<Integer, String> originalHashMap = new HashMap<>();

        originalHashMap.put(1, "Vova");
        originalHashMap.put(2, "Pasha");
        originalHashMap.put(3, "Vlad");

        // forEach цикл через EntrySet
        HashMap<String, Integer> swappedHashMap = new HashMap<>();

        for (Map.Entry<Integer, String> entry : originalHashMap.entrySet()) {
            swappedHashMap.put(entry.getValue(), entry.getKey());
        }
        System.out.println(swappedHashMap);

        //StreamApi, анонимные классы
        HashMap<String, Integer> swappedHashMap2 = originalHashMap.entrySet().stream()
                .collect(Collectors.toMap(
                        new Function<Map.Entry<Integer, String>, String>() {
                            @Override
                            public String apply(Map.Entry<Integer, String> entry) {
                                return entry.getValue();
                            }
                        },
                        new Function<Map.Entry<Integer, String>, Integer>() {
                            @Override
                            public Integer apply(Map.Entry<Integer, String> entry) {
                                return entry.getKey();
                            }
                        },
                        new BinaryOperator<>() {
                            @Override
                            public Integer apply(Integer existing, Integer replacement) {
                                return existing;
                            }
                        }, new Supplier<HashMap<String, Integer>>() {
                            @Override
                            public HashMap<String, Integer> get() {
                                return new HashMap<>();
                            }
                        }
                ));
        System.out.println(swappedHashMap2);

        //StreamApi , сокращение через лямбду/ссылки на методы
        HashMap<String, Integer> swappedHashMap3 = originalHashMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry<Integer, String>::getValue,
                        Map.Entry<Integer, String>::getKey,
                        (existing, replacement) -> existing,
                        HashMap::new
                ));
        System.out.println(swappedHashMap3);

        //Сортировка по ключам, StreamApi + LinkedHashMap + ссылки
        HashMap<String, Integer> swappedAndSortedHashMap = originalHashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry<Integer, String>::getValue,
                        Map.Entry<Integer, String>::getKey,
                        (existing, replacement) -> existing,
                        LinkedHashMap::new
                ));
        System.out.println(swappedAndSortedHashMap);

        //Сортировка по значению, StreamApi + LinkedHashMap + анонимный класс Comparator
        HashMap<String, Integer> swappedAndSortedHashMap2 = originalHashMap.entrySet().stream()
                .sorted(new Comparator<>() {
                    @Override
                    public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                        return o1.getValue().compareTo(o2.getValue());
                    }
                })
                .collect(Collectors.toMap(
                        Map.Entry<Integer,String>::getValue,
                        Map.Entry<Integer,String>::getKey,
                        (existing,replacement) -> existing,
                        LinkedHashMap::new
                ));
        System.out.println(swappedHashMap2);
    }
}
