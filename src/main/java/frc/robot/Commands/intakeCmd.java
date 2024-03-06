// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import frc.robot.Subsystems.intakeSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example Intake. */
public class intakeCmd extends Command {
  private final intakeSubsystem Intake;
  private final double speed;

  public intakeCmd(intakeSubsystem Intake, double speed) {
    this.Intake = Intake;
    this.speed = speed;
    // Use addRequirements() here to declare Intake dependencies.
    addRequirements(Intake);
  }


  @Override
  public void initialize() {
}


@Override
public void execute() {
  Intake.setMotors(speed);
    
  }


  @Override
  public void end(boolean interrupted) {
    Intake.setMotors(0);
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
