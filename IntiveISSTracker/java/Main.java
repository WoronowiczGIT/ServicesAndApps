package SDA.IntiveISSTracker;

import SDA.IntiveISSTracker.Model.DataPackage;
import SDA.IntiveISSTracker.Model.Position;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        String address = "http://api.open-notify.org/iss-now.json";
        int clientPollIntervalInMs = 5000;

        JsonMapper toMapConverter = new JsonMapper();
        PositionParser positionParser = new PositionParser();
        DataFetcher dataFetcher = new DataFetcher(address);

        GeographicalCalculator calculator = new GeographicalCalculator();
            calculator.setFixedTimeInMs(clientPollIntervalInMs);
            calculator.isTimeFixed(true);

        Map map = toMapConverter.convert(dataFetcher.fetch());
       // Position oldPosition = positionParser.getPosition(map);
        Position oldPosition = toMapConverter.deserializer(dataFetcher.fetch());
        while (true) {
            Thread.sleep(clientPollIntervalInMs);

            map = toMapConverter.convert(dataFetcher.fetch());
         //   Position newPosition = positionParser.getPosition(map);
            Position newPosition = toMapConverter.deserializer(dataFetcher.fetch());

            DataPackage data = calculator.getCalculations(oldPosition, newPosition);
            oldPosition = newPosition;

            Presenter(data);
        }
    }

    static private void Presenter(DataPackage dataPackage) {
        System.out.println(" speed: " + (int) dataPackage.getSpeed() + " km/h,"
                + " distance: " + (int) dataPackage.getDistance() + " km,"
                + " time: " + (int) dataPackage.getTime() + " sec,"
                + " total time: " + (int) dataPackage.getTotalTime() + " sec,"
                + " total distance: " + (int) dataPackage.getTotalDistance() + " km,"
                + " average speed: " + (int) dataPackage.getAverageSpeed() + " km/h.");
    }

}
