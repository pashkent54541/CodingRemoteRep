/*
Развернуть строку без использования метода типа reverse()
 */

import java.util.Arrays;
import java.util.Stack;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReverseString {

    public static void main(String[] args) {
        String string = "Hello world!";
        reverse(string);
        System.out.println();
        System.out.println(reverse2(string));
        System.out.println(reverse3(string));
        System.out.println(reverse4(string));
        System.out.println(reverse5(string));
        System.out.println(reverse6(string));
    }

    //Наивное решение через 1 массив и вывод результата в консоль
    private static void reverse(String string) {
        char[] arr = string.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }

    //Метод возвращает String, используется 2 массива
    private static String reverse2(String string) {
        char[] originalCharArray = string.toCharArray();
        char[] reversedCharArr = new char[string.length()];
        for (int i = string.length() - 1, j = 0; i >= 0; i--, j++) {
            reversedCharArr[j] = originalCharArray[i];
        }
        return Arrays.toString(reversedCharArr);
    }

    //Метод возвращает String, используется 1 массив + StingBuilder
    private static String reverse3(String string) {
        var charArray = string.toCharArray();
        var reversedString = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            reversedString.append(charArray[i]);
        }
        return String.valueOf(reversedString);
    }

    //Метод возращает String, используется Stack , 1 массив + StringBuilder (какое-то извращение от нейросети)
    private static String reverse4(String string) {
        var charArray = string.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        var reversedString = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            characterStack.push(charArray[i]);
        }

        while (!characterStack.isEmpty()) {
            reversedString.append(characterStack.pop());
        }

        return reversedString.toString();
    }

    //Метод возвращает String, StreamApi, reduce
    private static String reverse5(String string) {
        return Stream.of(string.split("")).reduce("", (reversed, character) -> character + reversed);
    }

    //Метод возвращает String, StreamApi, mapToObj
    private static String reverse6(String string) {
        return IntStream.range(0, string.length())
                .mapToObj(new IntFunction<String>() {
                    @Override
                    public String apply(int i) {
                        return String.valueOf(string.charAt(string.length() - 1 - i));
                    }
                })
                .collect(Collectors.joining());
    }
}
