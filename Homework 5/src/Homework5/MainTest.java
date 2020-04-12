package Homework5;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class MainTest {

    public static void main(String[] args) {

        String separator = File.separator;
        String path1 = "C:"+separator+"Users"+separator+"Vlad"+separator+"Desktop"+separator+"test.txt";//"C:\Users\Vlad\Desktop\test.txt"
        String path = "C:"+separator+"Users"+separator+"Vlad"+separator+"Desktop"+separator+"Война и мир.txt";

        File file = new File(path);

        FileInputStream fis = null;
        InputStreamReader isr = null;
        int b = 0;
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            while ((b=isr.read())!=-1){
                System.out.print((char)b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fis != null;
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert isr != null;
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
