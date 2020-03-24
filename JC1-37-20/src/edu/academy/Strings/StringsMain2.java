package edu.academy.Strings;

public class StringsMain2 {
    public static void main(String[] args) {
        String ilya = "Илья";
        String fakeIlya = new String("Илья");

        System.out.println(ilya == fakeIlya);
        System.out.println(ilya.equals(fakeIlya));
        System.out.println(ilya == fakeIlya.intern());
        System.out.println(ilya == fakeIlya);
        fakeIlya = fakeIlya.intern();
    }
}
