public class Main {
    enum Countries {
        RUSSIA, SPAIN, FRANCE, GERMAN
    }

    public static void main(String[] args) {
        Main.Countries country = Countries.GERMAN;
        switch (country) {
            case SPAIN -> System.out.println("Испания");
            case FRANCE -> System.out.println("Франция");
            case RUSSIA -> System.out.println("Россия");
            default -> System.out.println("В классе нет страны");
        }
    }
}