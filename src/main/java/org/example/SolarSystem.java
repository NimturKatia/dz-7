package org.example;

public enum SolarSystem {
    MERCURY(0, 100),
    VENUS(2000, 200, MERCURY),
    EARTH(3000,300,VENUS),
    MARS(4000,400,EARTH),
    JUPITER(5000,500,MARS),
    SATURN(6000,600,JUPITER),
    URANUS(7000,700,SATURN),
    NEPTUNE(8000,800,URANUS);

    private int prevDistance = 0;
    private int radius = 0;
    private SolarSystem previous;
    private int planetNumberToSun = 0;
    private int distanceToSun = 0;

    // A general constructor
    SolarSystem(int prevDistance, int radius, SolarSystem previous){
        this.prevDistance = prevDistance;
        this.radius = radius;
        this.previous = previous;
        this.planetNumberToSun = previous.planetNumberToSun + 1;
        this.distanceToSun = previous.getDistanceToSun() + previous.getRadius() + this.prevDistance;
    }

    // A constructor for Mercury
    SolarSystem(int prevDistance, int radius){
        this.prevDistance = prevDistance;
        this.radius = radius;
        this.planetNumberToSun = 1;
        this.distanceToSun = 1000;
    }

    // Getters
    public int getPrevDistance() {
        return prevDistance;
    }

    public int getRadius() {
        return radius;
    }

    public int getDistanceToSun() {
        return distanceToSun;
    }

    public SolarSystem getPrevious() {
        return previous;
    }

    // Calculate Next separately
    SolarSystem calculateNextPlanet(){
        if (planetNumberToSun < SolarSystem.values().length) {
            return SolarSystem.values()[planetNumberToSun];
        } else {
            return null;
        }
    }


}
