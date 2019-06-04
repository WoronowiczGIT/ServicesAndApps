package SDA.Streams.FootballLeague.DataGenerator.SearchStrategy;

import java.io.StringWriter;
import java.util.function.UnaryOperator;

public class SearchForNames implements UnaryOperator<String> {
    /** Explanation: the names.txt contains a lot of unnecessary meta data,
     *  so we just fetch the first available sequence of letters in each line.
     ** @param input
     * @return
     */
    @Override
    public String apply(String input) {
        StringWriter writer = new StringWriter();

        input.chars()
                .filter(Character::isAlphabetic)
                .forEach(writer::write);

        return formatName(writer.toString());
    }

    String formatName (String name){
        String out="";
        if(!name.isEmpty()) {
             out = name.charAt(0)+ name.substring(1).toLowerCase();
        }
        return out;
    }

}
