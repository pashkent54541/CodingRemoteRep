/*
 Найти максимальное значение. Найти минимальное значение. Например:17,67,11,-11,4,0,5. Если массив + StreamApi.
 */

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        int size = 6;

        int result = Stream.iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0] + x[1]})
                .limit(size)
                .map(x -> x[0])
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(result);

        long a = 0;
        long b = 1;

        // Вывод первых десяти чисел
        System.out.println("Первые десять чисел Фибоначчи:");
        for (int i = 0; i < 10; i++) {
            System.out.print(a + " ");
            //Обновление переменных:
            //
            //long temp = a + b; создает временную переменную temp, в которую записывается
            // сумма текущего и предыдущего числа Фибоначчи.
            //a = b; присваивает значению a значение предыдущего числа Фибоначчи (значение b).
            //b = temp; присваивает значению b значение нового числа Фибоначчи (значение temp).??
            long temp = a + b;
            a = b;
            b = temp;
        }
    }

    public static int fibonacciValue(int x) {
        if (x <= 1) return x;
        return fibonacciValue(x - 1) + fibonacciValue(x - 2);
    }
//            Stream<Long> fibonacciStream = Stream.iterate(new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
//                    .map(f -> f[0]);
//
//            // Получаем n-е число в ряде Фибоначчи
//            long fibonacciNumber = fibonacciStream.limit(n).reduce((first, second) -> second).orElseThrow()
//        System.out.println("n-е число в ряде Фибоначчи: " + fibonacciNumber);


}
