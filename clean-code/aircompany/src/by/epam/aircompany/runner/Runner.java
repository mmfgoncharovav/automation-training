package by.epam.aircompany.runner;

import by.epam.aircompany.action.PlanesCreator;
import by.epam.aircompany.entity.airport.Airport;
import by.epam.aircompany.entity.type.MilitaryType;
import by.epam.aircompany.entity.plane.MilitaryPlane;
import by.epam.aircompany.entity.plane.PassengerPlane;
import by.epam.aircompany.entity.plane.Plane;

import java.util.Arrays;
import java.util.List;

public final class Runner {
    private Runner() {
    }
    public static void main(final String[] args) {
        Airport airport = new Airport(new PlanesCreator().getPlanesList());
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlanes());
        System.out.println("Military airport sorted by max distance: "
                + militaryAirport.sortByMaxDistance().toString());
        System.out.println("Passenger airport sorted by max speed: "
                + passengerAirport.sortByMaxSpeed().toString());
        System.out.println("Plane with max passenger capacity: "
                + passengerAirport.
                getPassengerPlaneWithMaxPassengersCapacity());
    }
}
