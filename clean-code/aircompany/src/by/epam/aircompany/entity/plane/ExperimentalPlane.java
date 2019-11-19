package by.epam.aircompany.entity.plane;

import by.epam.aircompany.entity.type.ClassificationLevelType;
import by.epam.aircompany.entity.type.ExperimentalType;

public class ExperimentalPlane extends Plane {

    private ExperimentalType experimentalType;
    private ClassificationLevelType classificationLevelType;

    public ExperimentalPlane(final String newModel, final int newMaxSpeed,
                             final int newMaxFlightDistance,
                             final int newMaxLoadCapacity,
                             final ExperimentalType newExperimentalType,
                             final ClassificationLevelType
                                     newClassificationLevelType) {
        super(newModel, newMaxSpeed, newMaxFlightDistance, newMaxLoadCapacity);
        this.experimentalType = newExperimentalType;
        this.classificationLevelType = newClassificationLevelType;
    }

    public void setClassificationLevelType(final ClassificationLevelType
                                                   newClassificationLevelType) {
        this.classificationLevelType = newClassificationLevelType;
    }

    public ClassificationLevelType getClassificationLevelType() {
        return classificationLevelType;
    }

    public void setExperimentalType(final ExperimentalType
                                            newExperimentalType) {
        this.experimentalType = newExperimentalType;
    }

    public ExperimentalType getExperimentalType() {
        return experimentalType;
    }

    @Override
    public boolean equals(final Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{"
                + "model='" + getModel() + '\''
                + '}';
    }
}
