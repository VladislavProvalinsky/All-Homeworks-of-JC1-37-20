package test.TestJava1;

interface I {
    public final static int EASY = 5;
        }

public class Test3 implements I {
    public static void main(String[] args) {
        int a = 5;
        test(++a);
    }
    static void test (int a){
        a += EASY + a++;
        System.out.println(a);
    }
}
