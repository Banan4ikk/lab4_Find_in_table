import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String file = "student-mat.csv";

        DataTable dataTable = new DataTable();
        dataTable.initDataTable(file);

        Scanner scanner = new Scanner(System.in);
        Scanner scannerWord = new Scanner(System.in);


        while (true) {
            System.out.println("""
                    1) Вывести всю таблицу
                    2) Найти строки
                    3) Выход
                    """);
            int menuItem = scanner.nextInt();

            switch (menuItem) {
                case 1:
                    dataTable.printAllTable();
                    break;
                case 2: {
                    System.out.print("Введите ключевое слово: ");
                    String patternWord = scannerWord.nextLine();
                    dataTable.findRows(patternWord);
                }
                break;
                default:
                    System.exit(0);
            }
        }


    }
}
