package org.example;

public enum SolarSystem {
    MERCURY(0, 0.38),
    VENUS(340, 0.72, MERCURY),
    EARTH(280,1000,VENUS),
    MARS(520,933,EARTH),
    JUPITER(3680,4850,MARS),
    SATURN(4320,8300,JUPITER),
    URANUS(9700,19200,SATURN),
    NEPTUNE(10880,29900,URANUS);

    private double prevDistance = 0;
    private double radius = 0;
    private SolarSystem previous;
    private int planetNumberToSun = 0;
    private double distanceToSun = 0;

    // A general constructor
    SolarSystem(double prevDistance, double radius, SolarSystem previous){
        this.prevDistance = prevDistance;
        this.radius = radius;
        this.previous = previous;
        this.planetNumberToSun = previous.planetNumberToSun + 1;
        this.distanceToSun = previous.getDistanceToSun() + this.prevDistance;
    }

    // A constructor for Mercury
    SolarSystem(double prevDistance, double radius){
        this.prevDistance = prevDistance;
        this.radius = radius;
        this.planetNumberToSun = 1;
        this.distanceToSun = 390;
    }

    // Getters
    public double getPrevDistance() {
        return prevDistance;
    }

    public double getRadius() {
        return radius;
    }

    public double getDistanceToSun() {
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
