import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //        Задание: Напиши программу, которая на вход примет ArrayList строк и
//        удаляет из него все дубликаты, не используя метод contains()
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("VOVA");
        arrayList.add("VOVA");
        arrayList.add("Vlad");
        arrayList.add("Pasha");

        System.out.println(arrayList);

        HashSet<String> hashSet = new HashSet<>(arrayList);
        arrayList.clear();
        arrayList.addAll(hashSet);

        System.out.println("result List: " + arrayList);

    }

 /*   private static ArrayList<String> removeDuplicates(ArrayList<String> list) {
        HashSet<String> set = new HashSet<>();
        set.addAll(list);

    }*/
}