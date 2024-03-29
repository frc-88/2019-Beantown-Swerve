package frc.robot;

public class RobotMap {

    ///////////////////////////////////////////////////////////////////////////
    // LAPG
    ///////////////////////////////////////////////////////////////////////////

    public static final int LAPG_DEPLOY_FORWARD = 7;
    public static final int LAPG_DEPLOY_REVERSE = 0;
    public static final int LAPG_GRAB_FORWARD = 5;
    public static final int LAPG_GRAB_REVERSE = 2;
    public static final int LAPG_NEUTRAL_FORWARD = 6;
    public static final int LAPG_NEUTRAL_REVERSE = 1;

    public static final int LAPG_GRAB_SWITCH = 8;

    public static final long LAPG_CLOSE_TIME = 500000;
    public static final long LAPG_OPEN_TIME = 500000;
    public static final long LAPG_RETRACT_TIME = 250000;
    
    public static final int LAPG_PCM_CAN_ID = 21;

    ///////////////////////////////////////////////////////////////////////////
    // MK2 SWERVE
    ///////////////////////////////////////////////////////////////////////////

    public static final int DRIVETRAIN_FRONT_LEFT_ANGLE_MOTOR = 3;
    public static final int DRIVETRAIN_FRONT_LEFT_ANGLE_ENCODER = 3;
    public static final int DRIVETRAIN_FRONT_LEFT_DRIVE_MOTOR = 15;

    public static final int DRIVETRAIN_FRONT_RIGHT_ANGLE_MOTOR = 2;
    public static final int DRIVETRAIN_FRONT_RIGHT_ANGLE_ENCODER = 2;
    public static final int DRIVETRAIN_FRONT_RIGHT_DRIVE_MOTOR = 13;
    
    public static final int DRIVETRAIN_BACK_LEFT_ANGLE_MOTOR = 0;
    public static final int DRIVETRAIN_BACK_LEFT_ANGLE_ENCODER = 0;
    public static final int DRIVETRAIN_BACK_LEFT_DRIVE_MOTOR = 1;

    public static final int DRIVETRAIN_BACK_RIGHT_ANGLE_MOTOR = 1;
    public static final int DRIVETRAIN_BACK_RIGHT_ANGLE_ENCODER = 1;
    public static final int DRIVETRAIN_BACK_RIGHT_DRIVE_MOTOR = 3;
    
    ///////////////////////////////////////////////////////////////////////////
    // OI
    ///////////////////////////////////////////////////////////////////////////

    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OPERATOR_CONTROLLER_PORT = 1;
    
}