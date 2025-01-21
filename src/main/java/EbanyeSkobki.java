/*
провалидруй строку
 */

import java.util.HashMap;
import java.util.Stack;

public class EbanyeSkobki {
    public static void main(String[] args) {
        String str = "([{}])";
        System.out.println(validate(str));
        System.out.println(validate2(str));
        System.out.println(validate3(str));
    }

    //switch-case конструкция
    private static boolean validate(String string) {
        char[] chars = string.toCharArray();
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        for (char ch : chars) {
            switch (ch) {
                case '(' -> counter1++;
                case ')' -> counter1--;
                case '[' -> counter2++;
                case ']' -> counter2--;
                case '{' -> counter3++;
                case '}' -> counter3--;
            }
        }
        return counter1 == 0 && counter2 == 0 && counter3 == 0;
    }

    //if-else
    private static boolean validate2(String string) {
        char[] chars = string.toCharArray();
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        for (char ch : chars) {
            if (ch == '(') {
                counter1++;
            } else if (ch == ')') {
                counter1--;
            } else if (ch == '[') {
                counter2++;
            } else if (ch == ']') {
                counter2--;
            } else if (ch == '{') {
                counter3++;
            } else if (ch == '}') {
                counter3--;
            }
        }
        return counter1 == 0 && counter2 == 0 && counter3 == 0;
    }

    //Stack + map
    private static boolean validate3(String string) {
        var charsArray = string.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (Character ch : charsArray) {
            if (map.containsValue(ch)) {
                characterStack.push(ch);
            } else if (characterStack.isEmpty() || characterStack.pop() != map.get(ch)) {
                return false;
            }
        }
        return characterStack.isEmpty();
    }
}
