package Woronowicz.Tests.Patterns;

public enum PaprotkaPattern {
    A50Be("50","",new String[]{"50","2,5,5"}), // normal
    AeB33("","3,3",new String[]{"9",""}), // normal factors
    A9Be("7","",new String[]{"7","7"}), // just prime
    A3B3("3","3",new String[]{"3",""}), // 2 primes
    A10B2("10","2",new String[]{"10","5"}), //missing number
    A10B3("10","3",new String[]{"klops"}), // wrong factor
    A0B0("0","0",new String[]{"klops"}), // zero zero
    A1B1("1","1",new String[]{"klops"}), // one one
    AnanB2("s","2",new String[]{"klops"}), // A nan
    AnanBnan("s","z",new String[]{"klops"}), // A n B are nan
    A10Bnan("10","z",new String[]{"klops"}), // B is nan
    A10B225("10","2,2,5",new String[]{"klops"}), // to much factors
    A0Be("0","",new String[]{"klops"}), // A zero
    AeB0("","0",new String[]{"klops"}), // B zero
    AeBe("","",new String[]{"klops"}), // B n B empty
    failTest("","",new String[]{"this test supose to fail"}); // B n B empty

    private String firstLine;
    private String secondLine;
    private String[] result;
    PaprotkaPattern(String firstLine,String secondLine,String[] result) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.result = result;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public String[] getResult() {
        return result;
    }
}
