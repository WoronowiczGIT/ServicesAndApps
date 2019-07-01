package myTester.Tests.Patterns;

public enum WilkPattern {
    toSmallFlow(new String[]{"klops"},new String[]{
            "1",
            "0.000001 2"
    }),
    toLargeFlowPrecision(new String[]{"60000","1"},new String[]{
            "1",
            "1.123456 2",
            "1 1"
    }),
    toLargeVolume(new String[]{"klops"},new String[]{
            "100001",
            "1.12345 2"
    }),
    incorrectSeparator(new String[]{"60000","1"},new String[]{
            "1",
            "1,12345 2",
            "1 1"
    }),
    zeroVolume(new String[]{"klops"},new String[]{
            "0",
            "1.12345 2"
    }),
    negativeVolume(new String[]{"klops"},new String[]{
            "-10",
            "1 2"
    }),
    undefinedFlow(new String[]{"klops"},new String[]{
            "1"
    }),
    undefinedTemp(new String[]{"60000","20"},new String[]{
            "1",
            "1",
            "1 20"
    }),
    undefinedVolume(new String[]{"klops"},new String[]{
            "1.12345 2",
            "1 1"
    }),
    toLargeTempPrecision(new String[]{"60000","1"},new String[]{
            "1",
            "1 2.123456",
            "1 1"
    }),
    toHighTemperature(new String[]{"60000","1"},new String[]{
            "1",
            "1 90.00001",
            "1 1"
    }),
    ToLowTemperature(new String[]{"60000","1"},new String[]{
            "1",
            "1 0.99999",
            "1 1"
    }),
    toManyArguments(new String[]{"60000","1"},new String[]{
            "1",
            "123 123 123",
            "1 1"
    }),
    lowFlow(new String[]{"120148140000","20"},new String[]{
                    "100.12345",
                    "0.00001 20",
                    "0.00001 20",
                    "0.00001 20",
                    "0.00001 20",
                    "0.00001 20"
    }),
    HighFlow(new String[]{"1.12345","45.5"},new String[]{
                    "1.12345",
                    "9999.99999 1" ,
                    "9999.99999 90" ,
                    "9999.99999 1" ,
                    "9999.99999 90" ,
                    "9999.99999 1" ,
                    "9999.99999 90"
    }),
    lettersInVolume(new String[]{"klops"},new String[]{
            "WS",
            "123 123",
            "1 1"
    }),
    failTest(new String[]{"this test","need to fail"},new String[]{});


    private String[] csv;
    private String[] result;


    WilkPattern(String[] result,String[] csv) {
        this.csv = csv;
        this.result = result;

    }

    public String[] getCsv() {
        return csv;
    }

    public String[] getResult() {
        return result;
    }


}
