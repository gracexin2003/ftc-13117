package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * In this program, the side of the robot that is facing the jewels has the color sensor.
 * The color sensor is supposed to sense the color of the ball on the right side of the podium.
 */

@TeleOp(name="Jewel_Blue", group="Linear Opmode")
public class Jewel_Blue extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    ColorSensor cs;
    Color c;

    Servo mainServo;
    Servo secondServo;
    double servoPosition = 0.0;

    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor leftBackMotor;
    DcMotor rightBackMotor;
    
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        cs = hardwareMap.colorSensor.get("Color Sensor");
        cs.enableLed(true);
        
        
        secondServo = hardwareMap.servo.get("servo2");
        secondServo.setPosition(servoPosition);
        mainServo = hardwareMap.servo.get("servo1");
        mainServo.setPosition(servoPosition);

        waitForStart();
        runtime.reset();

        servoPosition = 1.0;
        secondServo.setPosition(servoPosition);
        
        sleep(500);
        
        mainServo.setPosition(servoPosition);

        leftMotor = hardwareMap.dcMotor.get("Left_Motor");
        rightMotor = hardwareMap.dcMotor.get("Right_Motor");
        leftBackMotor = hardwareMap.dcMotor.get("Left_Back_Motor");
        rightBackMotor= hardwareMap.dcMotor.get("Right_Back_Motor");
        
        if (cs.blue() > 200) { //I'm not sure it works this way - help, any1?
            leftMotor.setPower(0.0);
            rightMotor.setPower(0.5);
            leftBackMotor.setPower(0.0);
            rightBackMotor.setPower(0.5);
        }else{
            leftMotor.setPower(0.5);
            rightMotor.setPower(0.0);
            leftBackMotor.setPower(0.5);
            rightBackMotor.setPower(0.0);
        }

        servoPosition = 0.0;
        mainServo.setPosition(servoPosition);
        secondServo.setPosition(servoPosition);

    }
}
