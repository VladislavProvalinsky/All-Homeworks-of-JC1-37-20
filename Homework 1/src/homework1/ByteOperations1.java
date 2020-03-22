package homework1;

public class ByteOperations1 {
    public static void main(String[] args) {
        int a = 42; // 00101010 в двоичной системе
        int b = 15; // 00001111 в двоичной системе

        int c = ~a; // 11010101
        int d = a | b; // 00101111
        int e = a & b; // 00001010
        int f = a ^ b; // 00100101
        int g = a >> 3; // 00000101
        int h = a >>> 3; // 00000101
        int i = a << 3; // 101010000
        int j = a &= b; // 00001010
        a=42;
        int k = a |= b; // 00001111
        a=42;
        int l = a ^= b; // 00100101
        a=42;
        int m = a >>=3; // 00000101
        a=42;
        int n = a >>>= 3; // 00000101
        a=42;
        int o = a <<= 3; // 101010000

        System.out.println("Результат ~a: "+c);
        System.out.println("Результат a|b: "+d);
        System.out.println("Результат a&b: "+e);
        System.out.println("Результат a^b: "+f);
        System.out.println("Результат a>>3: "+g);
        System.out.println("Результат a>>>3: "+h);
        System.out.println("Результат a<<3: "+i);
        System.out.println("Результат a&=b: "+j);
        System.out.println("Результат a|=b: "+k);
        System.out.println("Результат a^=b: "+l);
        System.out.println("Результат a>>=b: "+m);
        System.out.println("Результат a>>>=b: "+n);
        System.out.println("Результат a<<=b: "+o);
    }
}
