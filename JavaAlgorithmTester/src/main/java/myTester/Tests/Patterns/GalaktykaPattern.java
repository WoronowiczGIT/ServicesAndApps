package myTester.Tests.Patterns;

public enum GalaktykaPattern {
    W1("1W", new String[]{
            "***" ,
            "  *" ,
            "* *" ,
            "***" ,
            "3"}),
    S1("1S", new String[]{
            "****" ,
            "*  *" ,
            "* **" ,
            "3"}),
    E1("1E", new String[]{
            "***",
            "* *",
            "*",
            "***",
            "3"}),
    N1("1N", new String[]{
            "** *" ,
            "*  *" ,
            "****" ,
            "3"}),

    w1("1w", new String[]{"klops"}),
    s1("1s", new String[]{"klops"}),
    n1("1n", new String[]{"klops"}),
    e1("1e", new String[]{"klops"}),

    W0("0W", new String[]{"klops"}),
    W("W", new String[]{"klops"}),
    noLetter1("1", new String[]{"klops"}),
    Wneg10("-10W", new String[]{"klops"}),
    W10001("10001W", new String[]{"klops"}),
    failTest("100S", new String[]{"this tail must be failed"});

    GalaktykaPattern(String input, String[] result){
        this.input = input;
        this.result = result;
    }

    private String input;
    private  String[] result;

    public String getInput() {
        return input;
    }

    public String[] getResult() {
        return result;
    }
}
