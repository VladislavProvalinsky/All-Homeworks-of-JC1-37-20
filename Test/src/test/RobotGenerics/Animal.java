package test.RobotGenerics;

public class Animal {

    private int id;

    public Animal(){}

    public Animal (int id){
        this.id=id;
    }

    public int getId (){
        return id;
    }
    public static void eat (){
        System.out.println("Animal is eating...");
    }
}

