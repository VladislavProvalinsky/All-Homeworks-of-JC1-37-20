//ДЗ7:
// Создать мэйн в котором будут генерироваться студенты. 100 тыс в список. Использовать метод writeObject. После этого
// сохранить эту информацию в файл. Создать мэйн в котором прочитать данный файл. Сохранить всех студентов в список.
// Прошу учесть что на момент написание второго мэйна вы не знаете точное количество студентов в файле
// Отсортировать студентов по алфавиту и сохранить информацию в новый файл но уже сохранять не объекты через writeObject
// а поля объектов через другие методы writeXXX

package Homework8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainGeneratorWriter {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            students.add(new Student(i));
        }
        try {
            Student.writeStudents(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(students);
    }
}
