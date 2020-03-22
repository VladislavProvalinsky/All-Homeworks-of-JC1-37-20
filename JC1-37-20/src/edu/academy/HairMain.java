package edu.academy;

public class HairMain {
    public static void main(String[] args) {
        int hairMaks = 0;
        int hairIlya = 0;
        hairMaks = hairMaks + 1;
        hairIlya = hairMaks;

        System.out.println("maks : " + hairMaks);
        System.out.println("ilya : " + hairIlya);
        for (int i = 0; i < 10; i++) {
            hairMaks = hairMaks + 1;
        }
        System.out.println("maks : " + hairMaks);
        System.out.println("ilya : " + hairIlya);

    }
}
