package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("------------------------------");
        System.out.println("For distances were used AUs (Astronomical Units) multiplied by 1000");
        printPlanets();
    }

    public static void printPlanets() {
        for (SolarSystem planet : SolarSystem.values()){
            System.out.println("------------------------------");
            System.out.println("Planet name: " + planet.name());
            System.out.println("Planet radius: " + planet.getRadius());
            System.out.println("Planet distance to previous planet: " + planet.getPrevDistance());
            System.out.println("Planet distance to Sun: " + planet.getDistanceToSun());
            if (planet.getPrevious() != null) {
                System.out.println("Previous planet: " + planet.getPrevious());
            } else {
                System.out.println("There is no previous planet!");
            }

            if (planet.calculateNextPlanet() != null) {
                System.out.println("Next planet: " + planet.calculateNextPlanet().name());
            } else {
                System.out.println("There is no next planet!");
            }
            System.out.println("------------------------------");
        }
    }
}
