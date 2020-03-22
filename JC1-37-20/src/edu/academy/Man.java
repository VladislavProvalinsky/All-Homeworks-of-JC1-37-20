package edu.academy;

public class Man {
    private int hairLength;

    public Man(int startHairLength){
        hairLength = startHairLength;
    }

    public Man(){

    }

    public int getHairLength() {
        return hairLength;
    }

    public void setHairLength(int hairLength) {
        this.hairLength = hairLength;
    }

    public void grow(){
        hairLength = hairLength + 1;
    }
}
