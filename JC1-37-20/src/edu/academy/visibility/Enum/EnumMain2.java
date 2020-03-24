package edu.academy.visibility.Enum;

public class EnumMain2 {
    public static void main(String[] args) {
        Day dayinfo = Day.valueOfIgnoreCase("TUESDAy");
        System.out.println(dayinfo);
    }
}
