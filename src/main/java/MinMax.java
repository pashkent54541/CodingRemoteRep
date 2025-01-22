/*
 Найти максимальное значение. Найти минимальное значение. Например:17,67,11,-11,4,0,5. Если массив + StreamApi.
 */

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MinMax {
    public static void main(String[] args) {
        int[] arr = {17, 67, 11, -11, 4, 0, 5};
        int[] arr2 = {};
        System.out.println(findMax(arr));
        System.out.println(findMax2(arr));
        System.out.println(findMax3(arr));
        findMax4();
        findMax5();
        findMaxAndMin();
        System.out.println(findMax6(arr));
        System.out.println(findMax6(arr2));
    }

    //как в 5-ом классе информатики
    private static int findMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    //использование интерфейса Arrays
    private static int findMax2(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    //использование подходящей коллекции (TreeSet, неоптимально)
    private static int findMax3(int[] arr) {
        TreeSet<Integer> integerTreeSet = new TreeSet<>();

        for (int i : arr) {
            integerTreeSet.add(i);
        }
        return integerTreeSet.last();
    }

    //StreamApi
    private static void findMax4() {
        List<Integer> list = Stream.of(17, 67, 11, -11, 4, 0, 5).sorted(Integer::compareTo).toList();
        System.out.println(list.get(list.size() - 1));
    }

    private static void findMax5() {
        int max = Stream.of(17, 67, 11, -11, 4, 0, 5).max(Integer::compareTo).get();
        System.out.println(max);
    }

    private static void findMaxAndMin() {
        Supplier<Stream<Integer>> streamSupplier = () -> Stream.of(17, 67, 11, -11, 4, 0, 5);
        Optional<Integer> maxValue = streamSupplier.get().max(Integer::compareTo);
        Optional<Integer> minValue = streamSupplier.get().min(Integer::compareTo);
        System.out.println(minValue + "" + maxValue);
    }

    private static int findMax6(int[] arr) {
        try {
            return Arrays.stream(arr).max().getAsInt();
        } catch (NoSuchElementException e) {
            return 0;
        }
    }
}
