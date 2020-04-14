package test.ArrayList_LinkedList;

public class Animal {
    private int id;
    private String name;

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String toString(){
        return id + ":" + name;
    }
}
