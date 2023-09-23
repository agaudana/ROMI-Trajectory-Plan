// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.shuffleboard.SuppliedValueWidget;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class ArcadeDrive extends CommandBase {
  RomiDrivetrain m_Drivetrain;
  Supplier<Double> speed;
  Supplier<Double> turn;


  /** Creates a new ArcadeDrive. */
  public ArcadeDrive(RomiDrivetrain drivetrain, Supplier<Double> speedValue, Supplier<Double> turnValue) {
    m_Drivetrain = drivetrain;
    speed = speedValue;
    turn = turnValue;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Drivetrain.arcadeDrive(speed.get(),turn.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
