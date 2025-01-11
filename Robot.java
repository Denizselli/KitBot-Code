// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANLowLevel.MotorType;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

private final CANSparkMax leftMotor1 = new CANSparkMax(8, MotorType.kBrushless);
private final CANSparkMax leftMotor2 = new CANSparkMax(9, MotorType.kBrushless);
private final CANSparkMax rightMotor1 = new CANSparkMax(6, MotorType.kBrushless);
private final CANSparkMax rightMotor2 = new CANSparkMax(7, MotorType.kBrushless);
private final CANSparkMax topMotor = new CANSparkMax(10, MotorType.kBrushless);

private Joystick joystick = new Joystick(0);

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    double speed = -joystick.getRawAxis(1) * 0.6;
    double rotation = joystick.getRawAxis(0) * 0.3;

    double topSpeed = -joystick.getRawAxis(5) * 0.5;

    double left = speed + rotation;
    double right = speed - rotation;

    leftMotor1.set(left);
    leftMotor2.set(left);
    rightMotor1.set(-right);
    rightMotor2.set(-right);
    topMotor.set(topSpeed);
   
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
