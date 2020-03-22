package homework2;

import java.util.Scanner;

public class ColorMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер цвета радуги: ");
        int ColorNumber = in.nextInt();
        Color Color = new Color(ColorNumber);
        System.out.println("Номер вашего цвета: " + Color.getNumber());
        System.out.println("Название вашего цвета: " + Color.getName());
    }
}
