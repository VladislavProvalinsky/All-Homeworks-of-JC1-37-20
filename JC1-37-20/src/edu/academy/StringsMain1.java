package edu.academy;

public class StringsMain1 {
    public static void main(String[] args) {
        String str = "Владик";
        System.out.println(String.format("Привет %s, как дела", str));
        String spacedString = "    Очень много пробелов      тут    и    вот    тут     ";
        System.out.println(spacedString);
        System.out.println(spacedString.concat("Алло"));
        String ilya = "Илья";
        String fakeilya = "Илья";
        System.out.println(ilya == fakeilya.intern());
    }
}
