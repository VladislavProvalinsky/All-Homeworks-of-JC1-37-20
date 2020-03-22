package homework1;

public class ByteOperations2 {
    public static void main(String[] args) {
        int a = -42; // 11010110 в двоичной системе
        int b = -15; // 11110001 в двоичной системе

        int c = ~a; // 00101001
        int d = a | b; // 11110111
        int e = a & b; // 11010000
        int f = a ^ b; // 00100111
        int g = a >> 3; // 11111010
        int h = a >>> 3; // 11111111 11111111 11111111 11111010
        int i = a << 3; // 110101100000
        int j = a &= b; // 11010000
        a=-42;
        int k = a |= b; // 11110111
        a=-42;
        int l = a ^= b; // 00100111
        a=-42;
        int m = a >>=3; // 11111010
        a=-42;
        int n = a >>>= 3; // 00000101
        a=-42;
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
