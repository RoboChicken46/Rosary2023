package frc.robot.commands.drive;

import frc.robot.Constants;
import frc.robot.ApriltagVision;
import frc.robot.subsystems.DriveSubsystem;
import friarLib2.utility.Vector3309;


public class TurnInDirectionOfApriltag extends DriveTeleop {
    public TurnInDirectionOfApriltag (DriveSubsystem drive) {
        super(drive);
    }
     /**
     * Use the data from the vision system to point towards the target
     */
    @Override
    protected double calculateRotationalSpeed (Vector3309 translationalSpeeds) {
        Constants.Drive.VISION_AIM_PID.setSetpoint(1);

        if (ApriltagVision.shooterCamera.hasTargets()) {  //TODO shooterCamera is not for a shooter, change this later
            return Constants.Drive.VISION_AIM_PID.calculate(ApriltagVision.shooterCamera.getBestTarget().getX());
        }
        
        // Use driver input if no target is found
        return super.calculateRotationalSpeed(translationalSpeeds);
    }
    
}