// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import frc.robot.Constants;
import frc.robot.Subsystems.shooterSubsystem;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class shooterCmd extends Command {
  private final shooterSubsystem shooter;
  private final double velocity;
  // private final PIDController PID;
//   double LeftSpeed;

  public shooterCmd(shooterSubsystem shooter, double velocity) {
    this.shooter = shooter;
    this.velocity = velocity;
    // Use addRequirements() here to declare subsystem dependencies.
    // this.PID = new PIDController(Constants.Shooter.kp, 0, Constants.Shooter.kd);
    addRequirements(shooter);
  }


  @Override
  public void initialize() {
}


@Override
public void execute() {

  // shooter.setMotors(PID.calculate(shooter.getVelocity1(), velocity), PID.calculate(shooter.getVelocity2(), velocity));
  shooter.setMotors(velocity);
  // if(Constants.smartEnable){
    // SmartDashboard.putNumber("velocity1", shooter.getVelocity1());
    // SmartDashboard.putNumber("velocity2", shooter.getVelocity2());
    // SmartDashboard.putNumber("desired velocity", velocity);
  
  }


  @Override
  public void end(boolean interrupted) {
    shooter.setMotors(0);
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}