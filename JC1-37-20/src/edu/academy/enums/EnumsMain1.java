package edu.academy.enums;

public class EnumsMain1 {
    public static void main(String[] args) {
        Day dayInfo1 = Day.MONDAY;
        Day dayInfo2 = Day.MONDAY;

        System.out.println(dayInfo1 == dayInfo2);
        System.out.println(dayInfo1.equals(dayInfo2));
    }
}
