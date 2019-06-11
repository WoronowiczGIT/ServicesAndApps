package Woronowicz.Tests.Patterns;

public enum GalaktykaPattern {
    test1("10","50",
            "*                 *                 *\n" +
            " *               * *               * *\n" +
            "  *             *   *             *   *\n" +
            "   *           *     *           *     *\n" +
            "    *         *       *         *       *\n" +
            "     *       *         *       *         *       *\n" +
            "      *     *           *     *           *     *\n" +
            "       *   *             *   *             *   *\n" +
            "        * *               * *               * *\n" +
            "         *                 *                 *");

    GalaktykaPattern(String amp, String length, String pattern) {
        this.amp = amp;
        this.length = length;
        this.pattern = pattern;
    }
    String amp;
    String length;
    String pattern;
}
