package frc.robot;

import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.lapg.LAPGActive;
import frc.robot.commands.lapg.LAPGClose;
import frc.robot.commands.lapg.LAPGDeploy;
import frc.robot.commands.lapg.LAPGGrab;
import frc.robot.commands.lapg.LAPGNeutral;
import frc.robot.commands.lapg.LAPGRetract;
import frc.robot.commands.lapg.LAPGScore;
import frc.robot.util.TJController;
import frc.robot.input.XboxController; //just use 2910 controls for driver

public class OI {

    public XboxController driverController;
    public TJController operatorController;

    public OI() {

        driverController = new XboxController(RobotMap.DRIVER_CONTROLLER_PORT);
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

        SmartDashboard.putData(new LAPGGrab());
        SmartDashboard.putData(new LAPGClose());
        SmartDashboard.putData(new LAPGNeutral());
        SmartDashboard.putData(new LAPGActive());
        SmartDashboard.putData(new LAPGDeploy());
        SmartDashboard.putData(new LAPGRetract());

        
    }
}