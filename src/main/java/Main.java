import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
        * Проверить соответствуют ли элементы массива шаблону e-mail с помощью регулярных выражений
        String[] emailList = { "test@mail.ru", "123-kkdf@gmail.com", "123@343.com", "123123@yandex.com", "test.test@gmail.com", "sdfsdf@gmail." }
        * */
        String[] emailList = {"test@mail.ru", "123-kkdf@gmail.com", "123@343.com", "123123@yandex.com", "test.test@gmail.com", "sdfsdf@gmail."};
        System.out.println(isValidate(emailList));
    }

    public static HashMap<String, Boolean> isValidate(String[] emails) {
        HashMap<String, Boolean> map = new HashMap<>();

        for (String mail: emails) {
            boolean valid = mail.matches("^[A-Za-z0-9\\+_.-]+@[A-Za-z.-]+\\.[A-Za-z]{2,}$");
            map.put(mail,valid);
        }
        return map;
    }
}