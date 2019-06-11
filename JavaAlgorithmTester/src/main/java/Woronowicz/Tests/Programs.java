package Woronowicz.Tests;

public enum Programs {
    Galaktyka("Galaktyka", new GalaktykaTest()),
    Wilk("Wilk", new WilkTest()),
    Trajektoria("Trajektoria",new TrajektoriaTest()),
    Paprotka("Paprotka",new PaprotkaTest()),
    Krolik("Krolik", new KrolikTest());

    private String name;
    private Test test;
    Programs(String name, Test test){
        this.name = name;
        this.test = test;
    }

    public String getName(){
        return name;
    }
    public Test getTest(){
        return test;
    }


}
