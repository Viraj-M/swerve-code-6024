// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class shooterSubsystem extends SubsystemBase {
    
    private final TalonSRX motor1 = new TalonSRX(Constants.Shooter.shooterLeftID);
    private final TalonSRX motor2 = new TalonSRX(Constants.Shooter.shooterRightID);
    // final SensorCollection sensor1 = motor1.getSensorCollection();
    // final SensorCollection sensor2 = motor2.getSensorCollection();

   
  /** Creates a new shooter. */

  public shooterSubsystem() {
    motor1.setInverted(Constants.Shooter.leftInvert);
    motor2.setInverted(Constants.Shooter.rightInvert);

    // motor1.setSelectedSensorPosition(sensor1.getPulseWidthPosition() & 0xFFF);
    // motor2.setSelectedSensorPosition(sensor1.getPulseWidthPosition() & 0xFFF);
    
    // motor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    // motor2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
  }


  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotors(double speed) {
    motor1.set(ControlMode.PercentOutput, speed);
    motor2.set(ControlMode.PercentOutput, speed);
  }

  // public double getVelocity1(){
  //   return sensor1.getPulseWidthVelocity();
  // }

  // public double getVelocity2(){
  //   return sensor2.getPulseWidthVelocity();
  // }

  // public double getPosition1(){
  //   return sensor1.getPulseWidthPosition();
  // }

  // public double getPosition2(){
  //   return sensor2.getPulseWidthPosition();
  // }

}
