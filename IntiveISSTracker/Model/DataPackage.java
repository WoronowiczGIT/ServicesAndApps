package SDA.IntiveISSTracker.Model;

public class DataPackage {
    private double speed;
    private double averageSpeed;
    private double distance;
    private double time;
    private double totalDistance;
    private double totalTime;

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public double getTotalTime() {
        return totalTime;
    }
}
