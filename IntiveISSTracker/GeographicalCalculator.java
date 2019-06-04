package SDA.IntiveISSTracker;

import SDA.IntiveISSTracker.Model.DataPackage;
import SDA.IntiveISSTracker.Model.Position;

class GeographicalCalculator {
    private static final int secondsInHour = 3600;
    private static final int millisecondsInSecond = 1000;
    private static final int earthRadius = 6371;
    private static final double radian = 180 / Math.PI;

    private Boolean isTimeFixed;
    private int fixedTime;
    private long totalTime;
    private Double totalDistance;
    private double distance;
    private double speed;
    private long time;


    public GeographicalCalculator() {
        this.isTimeFixed = false;
        this.fixedTime = 0;
        this.totalDistance = 0D;
        this.distance = 0;
        this.speed = 0;
        this.time = 0;
        this.totalTime = 0;
    }

    public DataPackage getCalculations(Position oldPosition, Position newPosition) {
        if (oldPosition.equals(null) || newPosition.equals(null)) return new DataPackage();

        distance = getDistanceInKm(oldPosition, newPosition);
        totalDistance += distance;
        time = (isTimeFixed) ? this.fixedTime : getTimeInSec(oldPosition, newPosition);
        totalTime += time;

        speed = getSpeedInKmH(oldPosition, newPosition);
        double averageSpeed = (totalDistance / totalTime) * secondsInHour;

        DataPackage data = new DataPackage();
        data.setAverageSpeed(averageSpeed);
        data.setSpeed(speed);
        data.setDistance(distance);
        data.setTotalDistance(totalDistance);
        data.setTime(time);
        data.setTotalTime(totalTime);

        return data;
    }
    public void isTimeFixed(Boolean isFixed){
        isTimeFixed = isFixed;
    }

    long getTimeInSec(Position oldPosition, Position newPosition) {

        return isTimeFixed ? fixedTime : newPosition.getTimestamp() - oldPosition.getTimestamp();
    }

    public void setFixedTimeInMs(int time) {
        fixedTime = time/millisecondsInSecond;
    }

    double getSpeedInKmH(Position oldPosition, Position newPosition) {

        long timeInSeconds = getTimeInSec(oldPosition, newPosition);
        double distanceInKm = getDistanceInKm(oldPosition, newPosition);

        double velocityKmS = distanceInKm / timeInSeconds;
        return velocityKmS * secondsInHour;
    }

    Double getDistanceInKm(Position oldPosition, Position newPosition) {
        double oldLatitude = oldPosition.getLatitude();
        double oldLongitude = oldPosition.getLongitude();
        double newLatitude = newPosition.getLatitude();
        double newLongitude = newPosition.getLongitude();

        Double distance = calculateDistance(oldLatitude, oldLongitude, newLatitude, newLongitude);
        return distance;
    }

    private static double calculateDistance(double lat1, double long1, double lat2, double long2) {

        double distance = Math.acos(Math.sin(lat2 / radian) * Math.sin(lat1 / radian) +
                Math.cos(lat2 / radian) * Math.cos(lat1 / radian) *
                        Math.cos((long1 - long2) / radian)) * earthRadius;
        return distance;
    }
}
