// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.auto.PIDConstants;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

/**
* The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
* constants. This class should not be used for any other purpose. All constants should be declared
* globally (i.e. public static). Do not put anything functional in this class.
*
* <p>It is advised to statically import this class (or one of its inner classes) wherever the
* constants are needed, to reduce verbosity.
*/
public final class Constants { 
    
    
    /**
    *  For Constants that are not in a subsystem
    */
    public static final int PCM_CAN_ID = 1;
    public static final int PIGEON_IMU_ID = 19;
    
    public static final PneumaticsModuleType PCM_TYPE= PneumaticsModuleType.REVPH;

    /**
    * Constants for the Drivetrain //TODO: This is merely a template. A lot of this you will have to figure out yourself
    */
    public static class Drive {
        /********** CAN ID's **********/
        
        /********** Module Translations **********/
        
        /********** Autonomous Motion Envelope **********/
        public static final double MAX_AUTON_SPEED = 2; // Meters/second
        public static final double MAX_AUTON_ACCELERATION = 2.5; // Meters/second squared
       
        /********** Holonomic Controller Gains **********/
        
        /******** PID Gains ********/
        public static final PIDController VISION_AIM_PID = new PIDController(0.3, 0, 0);
        
        /********** Teleop Control Adjustment **********/
        public static final double MAX_TELEOP_SPEED = 6; // Meters/second
        public static final double MAX_TELEOP_ROTATIONAL_SPEED = Math.toRadians(700); // Radians/second
        public static final double MAX_TELEOP_ACCELERATION = 7; // Maters/second squared
        public static final double MAX_TELEOP_DECELERATION = 11;

        /********** Auto Balance  **********/
        public static final double CHARGE_STATION_ANGLE_TRESHOLD_DEGREES = 3;
        public static final double CHARGE_STATION_DRIVE_KP = 0.06;

        public static final double CHARGE_STATION_TILT_ANGLE = 12;

        public static final double CHARGE_STATION_TILT_ANGLE_THRESHOLD = 0.5;

    }
}



