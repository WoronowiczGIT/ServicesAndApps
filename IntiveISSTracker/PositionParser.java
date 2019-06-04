package SDA.IntiveISSTracker;

import SDA.IntiveISSTracker.Model.Position;
import com.google.gson.JsonPrimitive;

import java.util.Map;

 public class PositionParser {
    public Position getPosition(Map map) {

        JsonPrimitive jsTime = (JsonPrimitive)map.get("timestamp");
        Long time = jsTime.getAsLong();

        JsonPrimitive jsLongitude = (JsonPrimitive)map.get("longitude");
        Double longitude = jsLongitude.getAsDouble();

        JsonPrimitive jsLatitude = (JsonPrimitive)map.get("latitude");
        Double latitude = jsLatitude.getAsDouble();

        return new Position(time, longitude, latitude);
    }

}
