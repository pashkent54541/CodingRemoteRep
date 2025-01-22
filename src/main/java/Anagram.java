/*
 Найти максимальное значение. Найти минимальное значение. Например:17,67,11,-11,4,0,5. Если массив + StreamApi.
 */

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Stream;

public class Anagram {
    public static void main(String[] args) {

    }

    public static boolean isAnagram(String real, String anagram) {
        if (real.length() != anagram.length()) {
            return false;
        }

        // Создаем массив для хранения количества вхождений каждого символа в первой строке
        int[] charCounts = new int[256]; // 256 символов ASCII

        // Подсчитываем количество вхождений каждого символа в первой строке
        for (char c : real.toCharArray()) {
            charCounts[c]++;
        }

        // Проверяем, есть ли такое же количество вхождений каждого символа во второй строке
        for (char c : anagram.toCharArray()) {
            charCounts[c]--;
            if (charCounts[c] < 0) {
                return false; // Если количество вхождений во второй строке больше, чем в первой, то строки не являются анаграммами
            }
        }

        return true; // Если все символы во второй строке встретились такое же количество раз, как в первой, то строки являются анаграммами
    }

    public static boolean isAnagram2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            if (map.containsKey(str1.charAt(i))) {
                map.put(str1.charAt(i),
                        map.get(str1.charAt(i)) + 1);
            } else {
                map.put(str1.charAt(i), 1);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (map.containsKey(str2.charAt(i))) {
                map.put(str2.charAt(i),
                        map.get(str2.charAt(i)) - 1);
            }
        }

        Set<Character> set = map.keySet();
        for (Character key : set) {
            if (map.get(key)
                    != 0) {
                return false;
            }
        }
        return true;
    }
}
