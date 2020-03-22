//3. Используя статью https://metanit.com/java/tutorial/2.9.php запросить у пользователя его имя. Если имя будет равно имени
// Вася тогда в консоль должно вывести сообщение "Привет!" на одной строке, а на второй "Я тебя так долго ждал". Если имя будет
// равно имени "Анастасия" тогда в консоль должно вывести сообщени "Я тебя так долго ждал". В случае если это будет другое имя
// то вывести сообщение "Добрый день, а вы кто?". Написать ТРИ ОТДЕЛЬНЫХ решения при помощи if, else if, switch. В примерах if
// и else if для сравнения имён использовать код на подобии Objects.equals("Имя1", "Имя2");

package homework1;

import java.util.Scanner;

public class ScannerIf {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = in.nextLine();
        if (name.equals("Вася")){
            System.out.println("\"Привет!\"" + "\n\"Я тебя так долго ждал\"");
            return;
        }
        if (name.equals("Анастасия")){
            System.out.println("\"Я тебя так долго ждал\"");
            return;
        }
        if (name.equals(name) != name.equals("Вася") || name.equals(name) != name.equals("Анастасия")){
            System.out.println("\"Добрый день, а вы кто?\"");
            return;
        }
    }
}
