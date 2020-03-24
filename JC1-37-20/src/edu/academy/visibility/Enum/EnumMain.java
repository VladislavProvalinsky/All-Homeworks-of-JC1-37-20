package edu.academy.visibility.Enum;

public class EnumMain {
    public static void main(String[] args) {
        Day dayinfo1 = Day.MONDAY;
        Day dayinfo2 = Day.MONDAY;

        System.out.println(dayinfo1==dayinfo2);
        System.out.println(dayinfo1.equals(dayinfo2));
    }
}
