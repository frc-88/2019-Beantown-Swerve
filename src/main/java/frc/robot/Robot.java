/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SPI;
import frc.robot.drivers.NavX;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.LAPG;
import frc.robot.subsystems.Limelight;

import org.frcteam2910.common.robot.subsystems.SubsystemManager;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.I2C;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
  public static SubsystemManager subsystemManager;

  public static LAPG m_lapg;

  public static NavX m_navx;

  public static OI m_oi;

  public static Limelight m_limelight;


  private boolean firstTeleopInit = true;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    // Subsystems should be initialized first
    //Init NavX with 2910 driver
    m_navx = new NavX(I2C.Port.kOnboard);

    m_navx.calibrate();


    subsystemManager = new SubsystemManager(
      DrivetrainSubsystem.getInstance()
    );
    subsystemManager.enableKinematicLoop(.01);
    m_lapg = new LAPG();

    // Initialize the OI afterwards
    m_oi = new OI();

    m_limelight = new Limelight();

    CameraServer.getInstance().startAutomaticCapture();

  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    SmartDashboard.putBoolean("LAPG Switch", m_lapg.getSwitch());
    subsystemManager.outputToSmartDashboard();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  @Override
  public void teleopInit(){
    if(firstTeleopInit){
      m_navx.calibrate();
      firstTeleopInit = false;
    }
  }
}
