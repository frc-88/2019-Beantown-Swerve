package frc.robot.drivers;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import org.frcteam2910.common.drivers.Gyroscope;
import org.frcteam2910.common.math.Rotation2;

public final class NavX extends Gyroscope {
    private final AHRS navX;

    public NavX(SPI.Port port) {
        this(port, (byte) 200);
    }

    public NavX(SPI.Port port, byte updateRate) {
        navX = new AHRS(port, updateRate);
    }
    
    public NavX(I2C.Port port){
        navX = new AHRS(port , (byte) 200);
    }

    @Override
    public void calibrate() {
        navX.reset();
    }

    @Override
    public Rotation2 getUnadjustedAngle() {
        return Rotation2.fromRadians((-1) * getAxis(Axis.YAW));
    }

    @Override
    public double getUnadjustedRate() {
        return (-1) * navX.getRate();
    }

    public double getAxis(Axis axis) {
        switch (axis) {
            case PITCH:
                return Math.toRadians(navX.getPitch());
            case ROLL:
                return Math.toRadians(navX.getRoll());
            case YAW:
                return Math.toRadians(navX.getYaw());
            default:
                return 0.0;
        }
    }

    public enum Axis {
        PITCH,
        ROLL,
        YAW
    }
}
