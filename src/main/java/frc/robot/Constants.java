package frc.robot;

import com.pathplanner.lib.util.PIDConstants;

import edu.wpi.first.math.geometry.Translation3d;
import swervelib.math.Matter;
import edu.wpi.first.math.util.Units;

public class Constants {
    public static final double ROBOT_MASS = 20;
    public static final Matter CHASSIS    = new Matter(new Translation3d(0, 0, Units.inchesToMeters(4)), ROBOT_MASS);
    public static final double LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag
    public static final boolean smartEnable = true;

    public static final class AutonConstants
  {

    public static final PIDConstants TRANSLATION_PID = new PIDConstants(8, 0, 0);
    public static final PIDConstants ANGLE_PID   = new PIDConstants(4, 0, 0);
  }

  public static final class DrivebaseConstants
  {

    // Hold time on motor brakes when disabled
    public static final double WHEEL_LOCK_TIME = 100; // seconds
  }

  public static class OperatorConstants
  {

    // Joystick Deadband
    public static final double LEFT_X_DEADBAND  = 0.1;
    public static final double LEFT_Y_DEADBAND  = 0.1;
    public static final double RIGHT_X_DEADBAND = 0.1;
  }

  public static class Intake
  {
    public static int intakeLeftID = 15;
    public static int intakeRightID = 16;
    public static double intakeSpeed = 0.2;
    public static boolean leftInvert = true; 
    public static boolean rightInvert = false; 

  }

  public static class Arm
  {
    public static final int armLeftID = 17;
    public static final int armRightID = 18;
    public static final double armSpeed = 0.2;
    public static final boolean leftInvert = false; 
    public static final boolean rightInvert = true; 
    public static final double absoluteOffset = 0;
    public static final double kp = 0.1;
    public static final double kd = 0.2;
  }

  public static class Shooter
  {
    public static final int shooterLeftID = 25;
    public static int shooterRightID = 26;
    public static boolean leftInvert = false; 
    public static boolean rightInvert = false; 
    public static double shootSpeed = 1;
    public static double kp = 0.001;
    public static double kd = 0.001;

    //1, 1tic/s, 0.001
  }

  public static class Climber {
    public static final int climberID = 40;
    public static final boolean climberInvert = false;
    public static final double climberSpeed = 0.5;
  }
}
