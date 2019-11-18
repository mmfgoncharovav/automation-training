package solver;

import exception.InvalidTriangleException;

public class TriangleChecker {
    public static boolean isTriangleValid (double a, double b, double c) throws InvalidTriangleException {

        if (a<=0 || b<=0 || c<=0) {
            throw new InvalidTriangleException("Triangle sides must be positive numbers");
        }

        if ( Double.isNaN(a + b + c)) {
            throw new InvalidTriangleException("Side must be a number");
        }

        if((a < b + c) && (b < a + c) && (c < a + b)) {
            return true;
        }
        else {
            return false;
        }
    }
}
