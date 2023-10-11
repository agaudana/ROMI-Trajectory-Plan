// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class DriveDistance extends CommandBase {
  /** Creates a new DriveDistance. */
  RomiDrivetrain m_Drivetrain;
  double speed;
  double turn;
  double distance;

  public DriveDistance(RomiDrivetrain drivetrain, double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Drivetrain = drivetrain;
    speed = 0.5;
    turn = 0;
    this.distance = distance;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   m_Drivetrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Drivetrain.arcadeDrive(speed, turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Drivetrain.arcadeDrive(0, 0);
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if((m_Drivetrain.getLeftDistanceInch()+m_Drivetrain.getRightDistanceInch())/2 >= distance) {
      return true;
    }
    else {
      return false;
    }
  }
}
