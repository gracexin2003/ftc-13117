package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Drivetrain", group="Linear Opmode")
public class LiftServos extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    Servo leftServo;
    Servo rightServo;
    Servo leftBackServo;
    Servo rightBackServo;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftServo = hardwareMap.servo.get("Left_Servo");
        rightServo = hardwareMap.servo.get("Right_Servo");
        leftBackServo = hardwareMap.servo.get("Left_Back_Servo");
        rightBackServo= hardwareMap.servo.get("Right_Back_Servo");

        waitForStart();
        runtime.reset();

        boolean open = false;
        boolean backOpen = false;

        while (opModeIsActive()) {
            if(gamepad1.right_trigger == 1) {
                open = false;
                leftServo.setPosition(0.0);
                rightServo.setPosition(0.0);
            }else if(gamepad1.right_bumper || open) {
                open = true;
                leftServo.setPosition(0.5);
                rightServo.setPosition(0.5);
            }

            if(gamepad1.left_trigger == 1){
                backOpen = false;
                leftBackServo.setPosition(0.0);
                rightBackServo.setPosition(0.0);
            }else if(gamepad1.left_bumper || backOpen) {
                backOpen = true;
                leftBackServo.setPosition(0.5);
                rightBackServo.setPosition(0.5);
            }

        }
    }

}
