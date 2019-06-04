package SDA.IntiveISSTracker.Model;

import com.google.gson.annotations.SerializedName;

public class Position {
    @SerializedName("timestamp")
    private long timestamp;
    @SerializedName("longitude")
    private double longitude;
    @SerializedName("latitude")
    private double latitude;

    public Position(long timestamp, double longitude, double latitude) {
        this.timestamp = timestamp;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
