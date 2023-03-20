// Note: This is an alternative version of the primary file
// Every angle is in radians

public class ArmPositionCalc {
    private static double length; // The length of the first and second segments
    private static double maxReach; // The maximum reach of the arm
    private static double maxRotation; // The maximum rotation for every pivot

    public ArmPositionCalc(double l, double rot) {
        length = l;

        maxReach = 2*length;
        maxRotation = rot;
    }
    /** 
     * Calculates the position of each of the arm segments required to reach the position of the given setpoint.
     * 
     * @param x the x coordinate (distance away) of the point
     * @param y the y coordinate of the point
     * @param z the z coordinate (height) of the point
     * @param pitch the desired pitch of the final pivot section in radians
     * @param yaw the desired pitch of the final pivot section in radians
     * 
     * @return The rotation of each of the arm segments in the form of an array of doubles, all in radians.
     * The array goes as follows: [Base Rotation, First Pivot, Second Pivot, Third Pivot, Third Cross Pivot]
     */
    public static double[] findPositions(double x, double y, double z, double pitch, double yaw) {
        double[] result = new double[4];

        // Calculates the base rotation
        if(x == 0)
            result[0] = 0;
        else if(y == 0)
            result[0] = Math.PI/2;
        result[0] = Math.atan2(y, x);

        // Converts the x into a value relative to the base (using Pythagorean Theorem)
        // and y to the vertical axis.
        // This is for ease of understanding the later code.
        double x = Math.sqrt(x*x + y*y);
        double y = z;

        // Checks if the point is within the reach of the arm
        if(z <= 0 || Math.sqrt(x*x + y*y) > maxReach || x < 0)
            return null;

        

        return result;
    }
}
