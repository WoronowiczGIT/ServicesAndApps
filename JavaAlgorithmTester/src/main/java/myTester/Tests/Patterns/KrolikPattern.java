package myTester.Tests.Patterns;

public enum KrolikPattern {
    singleRow("aaa","5", new String[]{
            "{aaa}",
            "2",
            "3"}),
    nameWOBracers("aaa","klops", new String[]{
            "aaa",
            "3"}),
    doubleNameSameColumn("aaa","3",new String[]{
                "{aaa}",
                "{aaa}",
                "3"}),
    doubleNameDifferentColumn("aaa","klops",new String[]{
                "{aaa},{aaa}",
                "2,1",
                "3,1"}),
    nameAtBottom("aaa","5",new String[]{
                "1",
                "4",
                "{aaa}"}),
    nameWOValues("aaa","klops",new String[]{
                "{aaa}"}),
    nameAsNumber("1","2",new String[]{
                "{1}",
                "1",
                "1"}),
    tripleBracer("{{}}","5",new String[]{
                "{{{}}}",
                "2",
                "3"}),
    maxValue("aaa","3",new String[]{
                "{aaa}",
                "10000",
                "3"}),
    minValue("aaa","3",new String[]{
                "{aaa}",
                "-10000",
                "3"}),
    negativeNumbers("aaa","0",new String[]{
            "{aaa}",
            "-100",
            "100"}),
    trash("aaa","3",new String[]{
            "{aaa},{aa},{bb},aaa",
            "asd,2,2,2,2,2,2,2sds,asda,dsad,asdad,asdas",
            "3,asda,asdasd,asdasd,asd"}),
    failTest("aaa","2",new String[]{
                "{aaa}",
                "1"});

     KrolikPattern(String name, String result,String[] csv) {
        this.name = name;
        this.result = result;
        this.csv = csv;
    }

    String name;
    String result;
    String[] csv;

    public String[] getCsv() {
        return csv;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }
}
