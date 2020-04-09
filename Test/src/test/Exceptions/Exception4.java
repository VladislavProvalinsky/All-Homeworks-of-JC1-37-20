package test.Exceptions;

import java.io.IOException;
import java.lang.invoke.LambdaConversionException;
import java.text.ParseException;

public class Exception4 {
    public static void main(String[] args) {
        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException | LambdaConversionException e) { // multicatch block
            System.out.println("ijkjk");;
        }

    }
    public static void run () throws IOException, ParseException, LambdaConversionException {

    }
}
