// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;

import frc.robot.Constants;

public class intakeSubsystem extends SubsystemBase {
    
    final CANSparkMax leftMotor = new CANSparkMax(Constants.Intake.intakeLeftID, MotorType.kBrushless);
    final CANSparkMax rightMotor = new CANSparkMax(Constants.Intake.intakeRightID, MotorType.kBrushless);
    final RelativeEncoder leftEncoder = leftMotor.getEncoder();
    final RelativeEncoder rightEncoder = rightMotor.getEncoder();
    /** Creates a new Intake. */
    
    public intakeSubsystem() {
      leftMotor.setInverted(Constants.Intake.leftInvert);
      rightMotor.setInverted(Constants.Intake.rightInvert);

      leftMotor.setIdleMode(IdleMode.kCoast);

      rightMotor.setIdleMode(IdleMode.kCoast);
    
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotors(double speed) {
    leftMotor.set(speed);
    rightMotor.set(speed);
  }

  public double getLeftEncoder(){
    return leftEncoder.getPosition();
  }

  public double getRightEncoder(){
    return rightEncoder.getPosition();
  }

}
