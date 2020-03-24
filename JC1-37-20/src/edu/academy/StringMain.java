package edu.academy;

public interface StringMain {
    public static void main(String[] args) {
        Long a = 127l;
        Long b = 127l;
        Long c = 128l;
        Long d = 128l;

        System.out.println(a==b);
        System.out.println(c==d);
    }
}
