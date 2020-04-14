package test.TestJava1;

public class Test2 {
    {
        System.out.println("1");
    }
    public static void main(String[] args) {
        System.out.println("2");
        new Test2();
    }
    static {
        System.out.println("3");
    }
}
