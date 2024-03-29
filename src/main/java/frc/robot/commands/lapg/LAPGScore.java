/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lapg;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class LAPGScore extends Command {
  private int state;
  private long startTime;

  public LAPGScore() {
    requires(Robot.m_lapg);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    state = 0;
    startTime = RobotController.getFPGATime();
    //Robot.m_drive.freeze();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    switch (state) {
    case 0:
      //close
      Robot.m_lapg.close();
      gotoNextStateAfterDelay(RobotMap.LAPG_CLOSE_TIME);
      break;
    case 1:
      // retract
      Robot.m_lapg.retract();
      gotoNextStateAfterDelay(RobotMap.LAPG_RETRACT_TIME);
      break;
    case 2:
      state = 99;
      break;
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return state == 99;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_lapg.setPanel(false);
    //Robot.m_drive.unfreeze();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.m_lapg.setPanel(false);
    //Robot.m_drive.unfreeze();
  }

  private void gotoNextStateAfterDelay(long delay) {
    if (RobotController.getFPGATime() - startTime > delay) {
      state++;
      startTime = RobotController.getFPGATime();
    }

  }
}
