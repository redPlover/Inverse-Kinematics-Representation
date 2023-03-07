// Note: This is an alternative version of the primary file

public class ArmPositionCalcAltVersion {
    private static final double maxHeight = 10; // The maximum height of the arm
    private static final double maxReach = 10; // The maximum reach of the arm

    public ArmPositionCalcAltVersion() {}
    /** 
     * Calculates the position of each of the arm segments required to reach the position of the given setpoint.
     * 
     * @param x the x coordinate (distance away) of the point
     * @param y the y coordinate of the point
     * @param z the z coordinate (height) of the point
     * 
     * @return The position of each of the arm segments in the form of an array of doubles.
     * The array goes as follows: [Base Rotation, First Pivot, Second Pivot, Third Pivot]
     */
    public static double[] findPositions(double x, double y, double z) {
        double[] result = new double[4];

        // Checks if the point is within the reach of the arm
        if(z <= 0 || z > maxHeight || Math.sqrt( + Math.sqrt(x*x + y*y)*Math.sqrt(x*x + y*y)) > maxReach)
            return null;

        // Calculates the base rotation
        if(x == 0)
            result[0] = 0;
        else if(y == 0)
            result[0] = Math.PI/2;
        result[0] = Math.atan2(y, x);

        // Converts the x into a value relative to the base (using Pythagorean Theorem)
        double b = Math.sqrt(x*x + y*y);

        return result;
    }
}
