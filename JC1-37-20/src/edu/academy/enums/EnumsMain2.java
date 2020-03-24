package edu.academy.enums;

import edu.academy.Man;

public class EnumsMain2 {
    public static void main(String[] args) {
        Day dayInfo = Day.valueOf("TUESDAY");
        Day saturday = Day.valueOf("SATURDAY");

        System.out.println(dayInfo);
        System.out.println(dayInfo.toString());
        System.out.println(dayInfo.name());
        System.out.println(dayInfo.isWorkingDay());

        System.out.println(saturday.isWorkingDay());
    }
}
