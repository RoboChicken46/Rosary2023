package frc.robot;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.vision.IVisionCamera;
import frc.robot.vision.LimelightCamera;
import frc.robot.vision.PhotonCameraWrapper;
import frc.robot.vision.utility.PixelToAngle;


/**
 * Container for the limelightvision systems
 */
public class LimelightVision {

    public static Command TogglePipelineCommand()
    {
        return Commands.runOnce( () -> shooterCamera.setPipeline(1 - shooterCamera.getPipeline()) );
    }

    public static Command SetPipelineCommand(int index)
    {
        return Commands.runOnce( () -> shooterCamera.setPipeline(index) );
    }
    
    
    public static IVisionCamera shooterCamera = new LimelightCamera();

    private static final PixelToAngle ANGLE_CONVERTER = new PixelToAngle(320, 240, 54, 41); // Constants for the limelight 2
    private static final double HEIGHT_OF_CAMERA = 0.7747; // Meters
    private static final double ANGLE_OF_CAMERA = 34.8; // Degrees

    private static double lastDistance = 0; // Return this if the robot does not have a target

    /**
     * @return the distance in meters from the target
     */
    public static double getMetersFromTarget () {
        try {
            double a2;
            if (shooterCamera instanceof PhotonCameraWrapper) {
                a2 = shooterCamera.getBestTarget().getY();
            } else {
                a2 = ANGLE_CONVERTER.calculateYAngle(shooterCamera.getBestTarget());
            }
            double a1 = ANGLE_OF_CAMERA;
            double h1 = HEIGHT_OF_CAMERA;
            double h2 = Units.inchesToMeters(12*8 + 8); // Height of target

            lastDistance = (h2 - h1) / Math.tan(Math.toRadians(a1 + a2));
        } catch (IndexOutOfBoundsException e) {} // If the camera has no target

        return lastDistance;
    }
}
