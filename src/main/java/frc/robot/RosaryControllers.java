package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

/*
* This class contains static references to the controllers and joysticks
*/

public class RosaryControllers {

   //Joysticks 
   public static Joystick LeftStick = new Joystick(0);
   public static Joystick RightStick = new Joystick(1);

   //Controllers
   public static XboxController RosaryXboxController = new XboxController(2);

}
