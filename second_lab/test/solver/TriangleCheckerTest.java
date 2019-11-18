package solver;

import exception.InvalidTriangleException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleCheckerTest {
    @Test
    public void isTriangleValidTestSideEqualSum() throws InvalidTriangleException {
        double a = 4;
        double b = 5;
        double c = a + b;
        assertFalse(TriangleChecker.isTriangleValid(a,b,c));
    }

    @Test
    public void isTriangleValidTestSideMoreSum() throws InvalidTriangleException {
        double a = 7;
        double b = 8;
        double c = a + b + 1;
        assertFalse(TriangleChecker.isTriangleValid(c,a,b));
    }

    @Test
    public void isTriangleValidTestInfinity() throws InvalidTriangleException {
        double a = Double.POSITIVE_INFINITY;
        double b = 4;
        double c = 3;
        assertFalse(TriangleChecker.isTriangleValid(a,b,c));
    }

    @Test
    public void isTriangleValidTestEquilateralInfinity() throws InvalidTriangleException {
        double a = Double.POSITIVE_INFINITY;

        assertFalse(TriangleChecker.isTriangleValid(a,a,a));
    }

    @Test
    public void isTriangleValidTestClassicTriangle() throws InvalidTriangleException {
        double a = 5;
        double c = 4;
        double b = 3;
        assertTrue(TriangleChecker.isTriangleValid(a,b,c));
    }

    @Test
    public void isTriangleValidTestIsoscelesTriangle() throws InvalidTriangleException {
        double a = 7;
        double b = 7;
        double c = 5;
        assertTrue(TriangleChecker.isTriangleValid(a,b,c));
    }

    @Test
    public void isTriangleValidTestOneSideZero() {
        double a = 0;
        double b = 1;
        double c = 3;
        assertThrows(InvalidTriangleException.class, ()-> {
            TriangleChecker.isTriangleValid(a,b,c);
        });
    }

    @Test
    public void isTriangleValidTestBigValues() throws InvalidTriangleException {
        double max = Double.MAX_VALUE - 10;
        double a = 3 + max;
        double b = 5 + max;
        double c = 4 + max;
        assertTrue(TriangleChecker.isTriangleValid(a,b,c));
    }

    @Test
    public void isTriangleValidTestEquilateralTriangle() throws InvalidTriangleException {
        double a = 2;
        assertTrue(TriangleChecker.isTriangleValid(a,a,a));
    }

    @Test
    public void isTriangleValidTestNotNumber() throws InvalidTriangleException {
        double a = 3;
        double b = 5;
        double c = Double.NaN;
        assertThrows(InvalidTriangleException.class, ()->{
            TriangleChecker.isTriangleValid(a,b,c);
        });
    }

}