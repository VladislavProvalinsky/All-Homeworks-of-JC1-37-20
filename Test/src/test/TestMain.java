package test;

import test.RobotGenerics.Animal;
import test.RobotGenerics.Dog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {

        List<Animal> animal = new ArrayList<>();
        animal.add(new Animal(1));
        animal.add(new Animal(2));
        List<Dog> dog = new ArrayList<>();
        dog.add(new Dog());
        dog.add(new Dog());



        TestMain.getAnimals(animal);
        TestMain.getAnimals(dog);

        char [] a = {'a','b','c','d','a'};
        String str = "Владик";
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

    }

    private static void getAnimals (List<? extends Animal> animals){
        for (Animal animal : animals) {
            Animal.eat();
        }
    }

}
