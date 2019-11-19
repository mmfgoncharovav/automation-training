package by.epam.aircompany.entity.plane;

import java.util.Objects;

public abstract class Plane {

    private String model;
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;

    public Plane(final String newModel,
                 final int newMaxSpeed,
                 final int newMaxFlightDistance,
                 final int newMaxLoadCapacity) {
        this.model = newModel;
        this.maxSpeed = newMaxSpeed;
        this.maxFlightDistance = newMaxFlightDistance;
        this.maxLoadCapacity = newMaxLoadCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return this.maxLoadCapacity;
    }

    @Override
    public String toString() {
        return "Plane{"
                + "model='" + model + '\''
                + ", maxSpeed=" + maxSpeed
                + ", maxFlightDistance=" + maxFlightDistance
                + ", maxLoadCapacity=" + maxLoadCapacity
                + '}';
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Plane)) {
            return false;
        }

        return maxSpeed == ((Plane) object).maxSpeed
               && maxFlightDistance == ((Plane) object).maxFlightDistance
               && maxLoadCapacity == ((Plane) object).maxLoadCapacity
               && Objects.equals(model, ((Plane) object).model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model,
                maxSpeed,
                maxFlightDistance,
                maxLoadCapacity);
    }
}
