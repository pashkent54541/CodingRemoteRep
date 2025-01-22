/*
 Найти максимальное значение. Найти минимальное значение. Например:17,67,11,-11,4,0,5. Если массив + StreamApi.
 */

import java.util.List;
import java.util.Map;

public class sum_key_value_sum {
    public static void main(String[] args) {
        // Посчитать сумму ключей и значений,
// нужно сложить все ключи и все инты во всех списках,
// а затем сложить сумму // ключей и занчений
//        var map = Map.of(
//                1, List.of(1, 2, 3, 4, 5),
//                2, List.of(1, 2, 3, 4, 5)
//        );
//        int keySum = map.keySet().stream().reduce(Integer::sum).get();
//        int valueSum = map.values().stream().flatMap(List::stream).reduce(Integer::sum).get();
//        System.out.println(keySum+valueSum);

//        var map = Map.of(
//                1,List.of(1,2,3),
//                2, List.of(1,2,3));
//
//        var sum = map.entrySet().stream()
//                .mapToInt(x->x.getKey()+x.getValue().stream().mapToInt(Integer::intValue).sum())
//                .sum();
//        System.out.println(sum);

//        var map = Map.of(
//                1, List.of(1, 1, 2),
//                2, List.of(1, 1, 2)
//        );

//        Map<Integer, List<Integer>> map = Map.of(
//                1, List.of(1, 1, 2),
//                2, List.of(1, 1, 2)
//        );
        Map<Integer, List<Integer>> map =Map.of(
                1, List.of(1, 1, 2),
                2, List.of(1, 1, 2)
        );
        int sum =map.entrySet().stream()
                .mapToInt(x -> x.getKey()+x.getValue().stream()
                        .mapToInt(p ->p).sum()).sum();
//
//        int sum = map.entrySet().stream()
//                .mapToInt(x-> x.getKey()+x.getValue().stream()
//                                .mapToInt(p -> p)
//                        .sum())
//                .sum();
        System.out.println(sum);
    }
}

//    .mapToIn