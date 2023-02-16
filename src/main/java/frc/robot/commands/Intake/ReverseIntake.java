package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class ReverseIntake extends CommandBase {
    private IntakeSubsystem intake;

    public ReverseIntake(IntakeSubsystem intake) {
        this.intake = intake;

        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.setTopIntakeRoller(-Constants.Intake.TOP_INTAKE_MOTOR_POWER);
        intake.setBottomIntakeRoller(-Constants.Intake.BOTTOM_INTAKE_MOTOR_POWER);
    }
}
