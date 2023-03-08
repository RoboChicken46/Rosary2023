package frc.robot.util;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

/**
 * Represents a 2d vector
 */
public class Vector {
    private double xComponent;
    private double yComponent;
    private Rotation2d direction;
    private double magnitude;

    private Vector (double xComponent, double yComponent, Rotation2d direction, double magnitude) {
        this.xComponent = xComponent;
        this.yComponent = yComponent;
        this.direction = direction;
        this.magnitude = magnitude;
    }

    private Vector () {}

    /**
     * Create a new vector from cartesian coordinates
     * 
     * @param xCoordinate
     * @param yCoordinate
     * @return A new Vector3309
     */
    public static Vector fromCartesianCoords (double xCoordinate, double yCoordinate) {
        return new Vector().setCartesianCoords(xCoordinate, yCoordinate);
    }

    /**
     * Create a new vector from radial coordinates
     * 
     * @param theta
     * @param magnitude
     * @return A new Vector3309
     */
    public static Vector fromRadialCoords (Rotation2d theta, double magnitude) {
        double xComponent = magnitude * Math.sin(theta.getRadians());
        double yComponent = magnitude * Math.cos(theta.getRadians());

        return new Vector(xComponent, yComponent, theta, magnitude);
    }

    /**
     * Move the vector to the specified coordinates
     * 
     * @param xCoordinate
     * @param yCoordinate
     * @return Self
     */
    public Vector setCartesianCoords (double xCoordinate, double yCoordinate) {
        Rotation2d direction = new Rotation2d(Math.atan2(yCoordinate, xCoordinate));
        double magnitude = Math.sqrt((yCoordinate * yCoordinate) + (xCoordinate * xCoordinate));

        xComponent = xCoordinate;
        yComponent = yCoordinate;
        this.direction = direction;
        this.magnitude = magnitude;

        return this;
    }

    /**
     * Move the vector to the specified coordinates
     * 
     * @param theta
     * @param magnitude
     * @return Self
     */
    public Vector setRadialCoords (Rotation2d theta, double magnitude) {
        double xComponent = magnitude * Math.sin(theta.getRadians());
        double yComponent = magnitude * Math.cos(theta.getRadians());

        this.xComponent = xComponent;
        this.yComponent = yComponent;
        direction = theta;
        this.magnitude = magnitude;

        return this;
    }

    /**
     * Set the magnitude to one
     * 
     * @return A new vector with magnitude of one
     */
    public Vector normalize () {
        return fromRadialCoords(direction, 1);
    }

    /**
     * Reduce the magnitude if it is above the specified threshold
     * 
     * @param maxValue
     * @return A new vector with the proper magnitude
     */
    public Vector capMagnitude (double maxValue) {
        double newMagnitude = (magnitude < maxValue) ? magnitude : maxValue;

        return Vector.fromRadialCoords(direction, newMagnitude);
    }

    /**
     * Scale the magnitude of the vector by the given factor
     *  
     * @param factor Multiply the magnitude by this value
     * @return A new, porperly scaled vector
     */
    public Vector scale (double factor) {
        return Vector.fromRadialCoords(direction, magnitude * factor);
    }

    public Translation2d getCartesanCoords () {
        return new Translation2d(xComponent, yComponent);
    }

    public double getXComponent () {
        return xComponent;
    }

    public void setXComponent (double xCoordinate) {
        setCartesianCoords(xCoordinate, yComponent);
    }

    public double getYComponent () {
        return yComponent;
    }

    public void setYComponent (double yCoordinate) {
        setCartesianCoords(xComponent, yCoordinate);
    }

    public Rotation2d getDirection () {
        return direction;
    }

    public double getDegrees () {
        return direction.getDegrees();
    }

    public double getRadians () {
        return direction.getDegrees();
    }

    public double getMagnitude () {
        return magnitude;
    }
}
