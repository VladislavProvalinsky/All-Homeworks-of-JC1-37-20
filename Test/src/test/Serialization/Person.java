package test.Serialization;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 4286839443655557098L;

    private int id;
    private transient String name;

    public Person(int id, String name){
        this.id=id;
        this.name=name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return id +":"+ name;
    }
}
