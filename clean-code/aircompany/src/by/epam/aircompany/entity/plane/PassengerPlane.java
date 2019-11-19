package by.epam.aircompany.entity.plane;

import java.util.Objects;

public class PassengerPlane extends Plane {

    private int passengersCapacity;

    public PassengerPlane(final String newModel,
                          final int newMaxSpeed,
                          final int newMaxFlightDistance,
                          final int newMaxLoadCapacity,
                          final int newPassengersCapacity) {
        super(newModel, newMaxSpeed, newMaxFlightDistance, newMaxLoadCapacity);
        this.passengersCapacity = newPassengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity
                + '}');
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof PassengerPlane) || !super.equals(object)) {
            return false;
        }

        return Objects.equals(passengersCapacity,
                ((PassengerPlane) object).passengersCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
