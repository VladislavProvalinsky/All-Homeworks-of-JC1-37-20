//ДЗ7:
// Создать мэйн в котором будут генерироваться студенты. 100 тыс в список. Использовать метод writeObject. После этого
// сохранить эту информацию в файл. Создать мэйн в котором прочитать данный файл. Сохранить всех студентов в список.
// Прошу учесть что на момент написание второго мэйна вы не знаете точное количество студентов в файле
// Отсортировать студентов по алфавиту и сохранить информацию в новый файл но уже сохранять не объекты через writeObject
// а поля объектов через другие методы writeXXX

package Homework8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student implements Serializable {

    private int id;
    private String name;

    public Student (){};

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id) {
        this.id = id;
        this.name = nameStudentGenerator();
    }

    public String nameStudentGenerator (){
        String[] names = {"Andy", "Bob", "John", "Mike", "Randy", "Tom", "Katy", "Linda", "Susan", "Jane"};
        return names[(int) (Math.random() * 10)];
    }

    public static void writeStudents(List<Student> listOfStudents) throws IOException {
        try(FileOutputStream fos = new FileOutputStream("Students.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            for (Student student: listOfStudents) {
                oos.writeObject(student);
                oos.reset();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Student> readStudents() throws ClassNotFoundException, IOException {
        List<Student> listOfStudents = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("Students.bin");
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (fis.available() != -1) {
                Student student = (Student) ois.readObject();
                listOfStudents.add(student);
            }
        } catch (EOFException e) {
            e.printStackTrace();
        }
        return listOfStudents;
    }

    private void writeObject(ObjectOutputStream out) throws IOException{
        out.putFields();
        out.writeFields();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id +":"+ name;
    }
}
