// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import java.io.File;
import frc.robot.Subsystems.SwerveSubsystem;

public class RobotContainer {

  private final SwerveSubsystem drivebase = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),
      "JsonConstants"));

  final CommandXboxController driverXbox = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();

    Command driveSwerve = drivebase.driveCommand(
        () -> -MathUtil.applyDeadband(driverXbox.getLeftY(), OperatorConstants.LEFT_Y_DEADBAND),
        () -> -MathUtil.applyDeadband(driverXbox.getLeftX(), OperatorConstants.LEFT_X_DEADBAND),
        () -> -driverXbox.getRightX());

    drivebase.setDefaultCommand(driveSwerve);
  }

  private void configureBindings() {

  }

  public Command getAutonomousCommand() {
    return drivebase.getAutonomousCommand("New Auto");
  }

  public void setMotorBrake(boolean brake) {
    drivebase.setMotorBrake(brake);
  }
}
