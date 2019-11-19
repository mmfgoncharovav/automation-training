package by.epam.aircompany.entity.plane;

import by.epam.aircompany.entity.type.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane {

    private MilitaryType militaryType;

    public MilitaryPlane(final String newModel,
                         final int newMaxSpeed,
                         final int newMaxFlightDistance,
                         final int newMaxLoadCapacity,
                         final MilitaryType newMilitaryType) {
        super(newModel, newMaxSpeed, newMaxFlightDistance, newMaxLoadCapacity);
        this.militaryType = newMilitaryType;
    }

    public MilitaryType getType() {
        return militaryType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + militaryType
                        + '}');
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof MilitaryPlane) || !super.equals(object)) {
            return false;
        }

        return militaryType == ((MilitaryPlane) object).militaryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryType);
    }
}
