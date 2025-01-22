import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // String[] str = {"Один", "Два"}
        // Один - 4
        String[] str = {"Один", "Два"};

        System.out.println(findDuplicate(str));

    }

    public static Map<String,Integer> findDuplicate(String[] strings) {
        Map<String, Integer> map = new HashMap<>();

        for (String nums : strings) {
            map.put(nums, nums.length());
        }

        /*for(Map.Entry<String,Integer> entry: map.entrySet()) {
            if(entry.getValue() > 1) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " штук");
            }
        }*/

        return map;
    }
}