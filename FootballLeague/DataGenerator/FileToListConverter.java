package SDA.Streams.FootballLeague.DataGenerator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.UnaryOperator;

public class FileToListConverter {

    List<String> getListFromFile(String fileName, UnaryOperator<String> strategy) throws IOException {
        File namesCSV = new File(".\\src\\main\\java\\SDA\\Streams\\FootballLeague\\TextFiles\\"+fileName);
        LineIterator iterator = FileUtils.lineIterator(namesCSV, "UTF-8");

        List<String> result = new ArrayList<>();
        while (iterator.hasNext()){
            String newName;
            newName = strategy.apply(iterator.next());
            result.add(newName);
        }
        return result;
    }
}
