package frc.robot;

import frc.robot.util.TJController;

public class OI {

    TJController driverController;
    TJController operatorController;

    public OI() {

        driverController = new TJController(RobotMap.DRIVER_CONTROLLER_PORT);
        operatorController = new TJController(RobotMap.OPERATOR_CONTROLLER_PORT);


    }
}