/*Shouldn't need major changes */
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RosaryControllers;

import java.util.concurrent.atomic.AtomicReference;

import static frc.robot.Constants.Drive.*;

//TODO: This is a very simple drivesubsystem that does not have kinematics or chassisspeeds. Please add that later
public class DriveSubsystem extends SubsystemBase {

    //Left Motors
    private final PWMSparkMax MotorA1 = new PWMSparkMax(0);
    private final PWMSparkMax MotorA2 = new PWMSparkMax(1);
    private final PWMSparkMax MotorB1 = new PWMSparkMax(2);
    private final PWMSparkMax MotorB2 = new PWMSparkMax(3);

    //Right Motors
    private final PWMSparkMax MotorC1 = new PWMSparkMax(4);
    private final PWMSparkMax MotorC2 = new PWMSparkMax(5);
    private final PWMSparkMax MotorD1 = new PWMSparkMax(6);
    private final PWMSparkMax MotorD2 = new PWMSparkMax(7);

    private final MotorControllerGroup leftSpeedGroup = new MotorControllerGroup(MotorA1, MotorA2, MotorB1, MotorB2);
    private final MotorControllerGroup rightSpeedGroup = new MotorControllerGroup(MotorC1, MotorC2, MotorD1, MotorD2);

    DifferentialDrive Drivetrain = new DifferentialDrive(leftSpeedGroup, rightSpeedGroup);

    public DriveSubsystem() 
    {

    }


    @Override
    public void periodic()
    {
        Drivetrain.arcadeDrive(RosaryControllers.LeftStick.getY(), RosaryControllers.RightStick.getZ());
    }

   


}