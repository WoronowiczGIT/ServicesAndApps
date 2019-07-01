package galaktyka.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GalacticValidator {
    private static final int minScope = 1;
    private static final int maxScope = 10000;
    private static final String inputPattern = "^[1-9]+\\d*[NSWE]$";

    public static boolean isArgumentValid(String line) {

        Pattern pattern = Pattern.compile(inputPattern);
        Matcher matcher = pattern.matcher(line);
            if(!matcher.matches()){ return false;}

            String value = line.substring(0,line.length()-1);

            try {
                int scale = Integer.parseInt(value);
                if ( scale < minScope || scale > maxScope) { return false; }

            }catch (NumberFormatException e) { return false; }

        return true;
    }
}
