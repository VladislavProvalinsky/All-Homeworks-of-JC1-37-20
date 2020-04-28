//ДЗ7:
// Создать мэйн в котором будут генерироваться студенты. 100 тыс в список. Использовать метод writeObject. После этого
// сохранить эту информацию в файл. Создать мэйн в котором прочитать данный файл. Сохранить всех студентов в список.
// Прошу учесть что на момент написание второго мэйна вы не знаете точное количество студентов в файле
// Отсортировать студентов по алфавиту и сохранить информацию в новый файл но уже сохранять не объекты через writeObject
// а поля объектов через другие методы writeXXX

package Homework8;

import java.io.*;
import java.util.*;

public class MainStudentReader {
    public static void main(String[] args) {
        List<Student> listOfStudents = null;
        try {
            listOfStudents = new ArrayList<>(Student.readStudents());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        assert listOfStudents != null;
        Collections.sort(listOfStudents, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println(listOfStudents);

        // Записываем в файл поля объектов листа студентов с помощью переопределенного метода writeObject
        try(FileOutputStream fos = new FileOutputStream("StudentsFields.bin",true);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            for (Student student : listOfStudents) {
                oos.writeObject(student);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
