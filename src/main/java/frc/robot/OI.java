package frc.robot;

import frc.robot.util.TJController;

public class OI {

    TJController driverController;
    TJController operatorController;

    public OI() {

        driverController = new TJController(0);
        operatorController = new TJController(1);

        
    }
}