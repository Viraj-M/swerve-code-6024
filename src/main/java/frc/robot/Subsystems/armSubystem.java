// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.wpilibj.DutyCycleEncoder;


import frc.robot.Constants;

public class armSubystem extends SubsystemBase {
  
  final CANSparkMax leftMotor = new CANSparkMax(Constants.Arm.armLeftID, MotorType.kBrushless);
  final CANSparkMax rightMotor = new CANSparkMax(Constants.Arm.armRightID, MotorType.kBrushless);
  final DutyCycleEncoder ThroughBoreEncoder = new  DutyCycleEncoder(1);
  
  /** Creates a new arm. */

  public armSubystem() {
    leftMotor.setInverted(Constants.Arm.leftInvert);
    rightMotor.setInverted(Constants.Arm.rightInvert);
    leftMotor.setIdleMode(IdleMode.kBrake);
    rightMotor.setIdleMode(IdleMode.kBrake);

  }


  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotors(double speed) {
    leftMotor.set(speed);
    rightMotor.set(speed);
  }

  public double getAbsoluteEncoder(){
    return ThroughBoreEncoder.getAbsolutePosition() - Constants.Arm.absoluteOffset;
  }
}
