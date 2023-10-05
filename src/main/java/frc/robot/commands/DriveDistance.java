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
  public DriveDistance(RomiDrivetrain drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Drivetrain = drivetrain;
    speed = 0.5;
    turn = 0;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

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
    RomiDrivetrain DistanceCheck = new RomiDrivetrain();
    if((DistanceCheck.getLeftDistanceInch()+DistanceCheck.getRightDistanceInch())/2 == 5) {
      return true;
    }
    else {
      return false;
    }
  }
}
