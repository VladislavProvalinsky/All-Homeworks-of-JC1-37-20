package test.Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {

        Person [] persons = {new Person(1, "Bob"), new Person(2, "Mike"), new Person(3, "Vlad")};

        try {
            FileOutputStream fos = new FileOutputStream("people.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(persons);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
