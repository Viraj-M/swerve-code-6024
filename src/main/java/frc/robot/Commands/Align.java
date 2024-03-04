// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Subsystems.SwerveSubsystem;

import java.util.List;

import org.opencv.core.Mat;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.Constants;

/**
 * An example command that uses an example subsystem.
 */
public class Align extends Command {

    private final SwerveSubsystem swerve;
    private final PIDController PIDang;
    final PhotonCamera photonCamera = new PhotonCamera("cam");

    public Align(SwerveSubsystem swerve) {
        this.swerve = swerve;
        this.PIDang = new PIDController(1, 0, 0.1);

        addRequirements(swerve);
    }

    @Override
    public void initialize() {
        PIDang.reset();
        photonCamera.setPipelineIndex(0);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // double ID = LimelightHelpers.getFiducialID("");

        SmartDashboard.putNumber("called", 1);

        var result = photonCamera.getLatestResult();
        boolean hasTargets = result.hasTargets();
        if (hasTargets) {
            List<PhotonTrackedTarget> targets = result.getTargets();
            PhotonTrackedTarget target = result.getBestTarget();
            for (PhotonTrackedTarget cur_target : targets) {
                if (cur_target.getFiducialId() == 5 || cur_target.getFiducialId() == 7) {
                    target = cur_target;
                    break;
                }
            }
        

            if (target.getFiducialId() == 5 || target.getFiducialId() == 7) {         
                
                SmartDashboard.putNumber("id", target.getFiducialId());

                double TX = Math.toRadians(target.getYaw());
                double TY = Math.toRadians(target.getPitch());

                double at_height = 0.580, r_centre_cam = 0.420;
                double at_cam = at_height/Math.tan(TY);
                double r_centre_at = at_cam + r_centre_cam;

                double lateral_distance = at_cam * Math.tan(TX);
                double alpha = Math.tanh(lateral_distance/r_centre_at);

               



                PIDang.setSetpoint(0);

                double rot = PIDang.calculate(alpha);
    
                // Command AlignSwerve = swerve.driveCommand(
                //         () -> 1,
                //         () -> 1,
                //         () -> 1, true, false);
                
                swerve.drive(new Translation2d(0,0), rot, true);
                
                if (Constants.smartEnable) {
                    SmartDashboard.putNumber("TX", TX);
                    // SmartDashboard.putNumber("TY", TY);

                    // SmartDashboard.putNumber("d2", d2);
                    // SmartDashboard.putNumber("a", a);

                    // SmartDashboard.putNumber("x", x);
                    // SmartDashboard.putNumber("y", y);
                    SmartDashboard.putNumber("rot", rot);
                    
                }
            } else {
                swerve.drive(new Translation2d(0, 0), 0, true);
            }

        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (Constants.smartEnable) {
            SmartDashboard.putString("Status", "finished");
        }
        return false;
    }

}