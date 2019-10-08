package frc.robot.commands.swerve;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DrivetrainSubsystem;
import org.frcteam2910.common.math.Rotation2;
import org.frcteam2910.common.math.Vector2;

public class HolonomicDriveCommand extends Command {
    public HolonomicDriveCommand() {
        requires(DrivetrainSubsystem.getInstance());
    }

    @Override
    protected void execute() {
        boolean ignoreScalars = Robot.m_oi.driverController.getLeftBumperButton().get();

        double forward = Robot.m_oi.driverController.getLeftYAxis().get(true);
        double strafe = (-1) * Robot.m_oi.driverController.getLeftXAxis().get(true);
        double rotation = (-1) * Robot.m_oi.driverController.getRightXAxis().get(true, ignoreScalars);

        boolean robotOriented = Robot.m_oi.driverController.getXButton().get();
        boolean reverseRobotOriented = Robot.m_oi.driverController.getYButton().get();

        Vector2 translation = new Vector2(forward, strafe);

        if (reverseRobotOriented) {
            robotOriented = true;
            translation = translation.rotateBy(Rotation2.fromDegrees(180.0));
        }




        DrivetrainSubsystem.getInstance().holonomicDrive(translation, rotation, !robotOriented);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
