package SDA.IntiveISSTracker;


import SDA.IntiveISSTracker.Model.Position;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

class JsonMapper {

    private Map<Object, Object> map;

    public Map convert(String json) {
        this.map = new HashMap<>();
        JsonObject obj = new JsonParser()
                .parse(json)
                .getAsJsonObject();

        mapJsonFields(obj);
        return this.map;
    }

    private void mapJsonFields(JsonObject object) {
        for (String key : object.keySet()) {

            if (object.get(key).isJsonPrimitive()) {
                map.put(key, object.get(key));
            } else {
                mapJsonFields(object.get(key).getAsJsonObject());
            }
        }
    }

    public Position deserializer(String json) {

        JsonObject root = (JsonObject) new JsonParser().parse(json);
        JsonObject issPosition = root.get("iss_position").getAsJsonObject();

        long ts = root.get("timestamp").getAsLong();
        double longitude = issPosition.get("longitude").getAsDouble();
        double latitude = issPosition.get("latitude").getAsDouble();

        return new Position(ts,longitude,latitude);
    }
}
