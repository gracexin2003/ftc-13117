package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Drivetrain", group="Linear Opmode")
public class Drivetrain extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    DcMotor leftBackMotor;
    DcMotor rightBackMotor;
    DcMotor frontLift;
    DcMotor backLift;
    Servo leftServo;
    Servo rightServo;
    Servo leftBackServo;
    Servo rightBackServo;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftBackMotor = hardwareMap.dcMotor.get("Left_Back_Motor");
        rightBackMotor = hardwareMap.dcMotor.get("Right_Back_Motor");

        rightBackMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackMotor.setPower(-gamepad1.left_stick_y/2.0);
        rightBackMotor.setPower(-gamepad1.right_stick_y/2.0);

        frontLift = hardwareMap.dcMotor.get("Front_Lift");
        backLift = hardwareMap.dcMotor.get("Back_Lift");

        leftServo = hardwareMap.servo.get("Left_Servo");
        leftServo.setPosition(0.1);
        //leftServo.setPosition(0.7);
        rightServo = hardwareMap.servo.get("Right_Servo");
        //rightServo.setPosition(0.3);
        rightServo.setPosition(0.7);
        leftBackServo = hardwareMap.servo.get("Left_Back_Servo");
        leftBackServo.setPosition(0.75);
        rightBackServo= hardwareMap.servo.get("Right_Back_Servo");
        //rightBackServo.setPosition(1);
        rightBackServo.setPosition(0.05);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            leftBackMotor.setPower(-gamepad1.left_stick_y);
            rightBackMotor.setPower(-gamepad1.right_stick_y);

            if(gamepad1.dpad_up){
                frontLift.setPower(1);
            } else {
                frontLift.setPower(0);
            }

            if(gamepad1.dpad_down){
                frontLift.setPower(-1);
            } else {
                frontLift.setPower(0);
            }

            if(gamepad1.y){
                backLift.setPower(1);
            } else {
                backLift.setPower(0);
            }

            if(gamepad1.a){
                backLift.setPower(-1);
            } else {
                backLift.setPower(0);
            }

            if(gamepad1.left_bumper) {
                leftServo.setPosition(0.55);
                rightServo.setPosition(0.25);
            }

            if(gamepad1.left_trigger != 0) {
                leftServo.setPosition(0.18);
                rightServo.setPosition(0.62);
            }

            if(gamepad1.right_bumper){
                leftBackServo.setPosition(0.25);
                rightBackServo.setPosition(0.4);
            }

            if(gamepad1.right_trigger != 0) {
                leftBackServo.setPosition(0.5);
                rightBackServo.setPosition(0.1);
            }
        }
    }
}