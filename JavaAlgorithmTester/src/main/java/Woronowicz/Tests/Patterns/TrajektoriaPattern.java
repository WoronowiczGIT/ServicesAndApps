package Woronowicz.Tests.Patterns;

public enum TrajektoriaPattern {
    A10L50("10","50",new String[]{
            "*                 *                 *",
            " *               * *               * *",
            "  *             *   *             *   *",
            "   *           *     *           *     *",
            "    *         *       *         *       *",
            "     *       *         *       *         *       *",
            "      *     *           *     *           *     *",
            "       *   *             *   *             *   *",
            "        * *               * *               * *",
            "         *                 *                 *"}),
    A1L10("1","10",new String[]{"**********"}),
    A0L1("1","0",new String[]{"klops"}),
    A1L0("0","1",new String[]{"klops"}),
    A50L10("50","10",new String[]{
            "*",
            " *",
            "  *",
            "   *",
            "    *",
            "     *",
            "      *",
            "       *",
            "        *",
            "         *"}),
    A0L0("0","0",new String[]{"klops"}),
    A1L1("1","1",new String[]{"*"}),
    A5L50("5","50",new String[]{
            "*       *       *       *       *       *       *",
            " *     * *     * *     * *     * *     * *     * *",
            "  *   *   *   *   *   *   *   *   *   *   *   *",
            "   * *     * *     * *     * *     * *     * *",
            "    *       *       *       *       *       *"}),
    AnanB1("D","1",new String[]{"klops"}),
    A1Bnan("1","B",new String[]{"klops"});

    TrajektoriaPattern(String amp, String length, String[] pattern) {
        this.amp = amp;
        this.length = length;
        this.pattern = pattern;
    }
    private String amp;
    private String length;
    private String[] pattern;

    public String getAmp() {
        return amp;
    }

    public String getLength() {
        return length;
    }

    public String[] getPattern() {
        return pattern;
    }
}
