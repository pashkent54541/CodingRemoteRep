import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // String[] str = {"Один", "Два"}
        // Один - 4
        String[] str = {"Один", "Два"};

        int[] arr = {1,2,3,4,4,5,6,7,7};
        findDuplicate(arr);

    }

    public static void findDuplicate(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int nums: arr) {
            map.put(nums,map.getOrDefault(nums,0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(entry.getValue() > 1) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " штук");
            }
        }
    }
}