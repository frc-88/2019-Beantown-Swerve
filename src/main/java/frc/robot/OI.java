package frc.robot;

import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.commands.lapg.LAPGDeploy;
import frc.robot.commands.lapg.LAPGGrab;
import frc.robot.commands.lapg.LAPGRetract;
import frc.robot.commands.lapg.LAPGScore;
import frc.robot.util.TJController;

public class OI {

    TJController driverController;
    TJController operatorController;

    public OI() {

        driverController = new TJController(RobotMap.DRIVER_CONTROLLER_PORT);
        operatorController = new TJController(RobotMap.OPERATOR_CONTROLLER_PORT);

        operatorController.buttonLeftBumper.whenActive(new LAPGDeploy());
        operatorController.buttonRightBumper.whenActive(new LAPGRetract());
        new Trigger(){
        
            @Override
            public boolean get() {
                return operatorController.getLeftTrigger() > 0.5;
            }
        }.whenActive(new LAPGScore());
        new Trigger(){
        
            @Override
            public boolean get() {
                return operatorController.getRightTrigger() > 0.5;
            }
        }.whenActive(new LAPGGrab());
        
    }
}