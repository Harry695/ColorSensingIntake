// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  private static final double INTAKE_POWER = 0.5;
  private static final double EJECT_POWER = 0.3;

  private CANSparkMax motor = new CANSparkMax(Constants.SparkMax.INTAKE, MotorType.kBrushless);
  private DoubleSolenoid solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.CTREPCM.INTAKE_FORWARD, Constants.CTREPCM.INTAKE_BACKWARD);

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    motor.setIdleMode(IdleMode.kCoast);
  }

  public void extendAndIntake() {
    solenoid.set(Value.kForward);
    motor.set(INTAKE_POWER);
  }

  public void extendAndOuttake() {
    solenoid.set(Value.kForward);
    motor.set(EJECT_POWER);
  }

  public void retractAndStopMotor() {
    solenoid.set(Value.kReverse);
    motor.set(0);
  }

  public boolean isExtended() {
    return solenoid.get().equals(Value.kForward);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
