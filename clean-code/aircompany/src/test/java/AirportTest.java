package test.java;
import by.epam.aircompany.action.PlanesCreator;
import by.epam.aircompany.entity.airport.Airport;
import by.epam.aircompany.entity.plane.ExperimentalPlane;
import by.epam.aircompany.entity.plane.MilitaryPlane;
import by.epam.aircompany.entity.plane.PassengerPlane;
import by.epam.aircompany.entity.plane.Plane;
import by.epam.aircompany.entity.type.ClassificationLevelType;
import by.epam.aircompany.entity.type.ExperimentalType;
import by.epam.aircompany.entity.type.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AirportTest {

    private static PassengerPlane planeWithMaxPassengerCapacity
            = new PassengerPlane("Boeing-747", 980,
            16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(new PlanesCreator().getPlanesList());
        List<MilitaryPlane> transportMilitaryPlanes
                = airport.getTransportMilitaryPlanes();

        boolean gatedTransportMilitaryPlanes = false;
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            if ((militaryPlane.getType() == MilitaryType.TRANSPORT)) {
                gatedTransportMilitaryPlanes = true;
                break;
            }
        }

        Assert.assertTrue(gatedTransportMilitaryPlanes);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(new PlanesCreator().getPlanesList());
        PassengerPlane expectedPlaneWithMaxPassengersCapacity
                = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(planeWithMaxPassengerCapacity,
                expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        Airport airport = new Airport(new PlanesCreator().getPlanesList());
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity
                = airport.getPlanes();

        boolean isSorted = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            if (planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity()
                    > planesSortedByMaxLoadCapacity.get(i + 1)
                    .getMaxLoadCapacity()) {
                isSorted = false;
                break;
            }
        }

        Assert.assertTrue(isSorted);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(new PlanesCreator().getPlanesList());
        List<MilitaryPlane> bomberMilitaryPlanes
                = airport.getBomberMilitaryPlanes();

        boolean hasBomber = false;
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            if ((militaryPlane.getType() == MilitaryType.BOMBER)) {
                hasBomber = true;
                break;
            }
        }

        Assert.assertTrue(hasBomber);
    }

    @Test
    public void
    testExperimentalPlanesHasClassificationLevelHigherThanUnclassified() {
        Airport airport = new Airport(new PlanesCreator().getPlanesList());
        List<ExperimentalPlane> experimentalPlanes
                = airport.getExperimentalPlanes();

        boolean hasClassificationLevelHigherThanUnclassified = true;
        for (ExperimentalPlane experimentalPlane : experimentalPlanes) {
            if (experimentalPlane.getClassificationLevelType()
                    == ClassificationLevelType.UNCLASSIFIED) {
                hasClassificationLevelHigherThanUnclassified = false;
                break;
            }
        }

        Assert.assertTrue(hasClassificationLevelHigherThanUnclassified);
    }
}
