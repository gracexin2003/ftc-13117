package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="Drivetrain", group="Linear Opmode")
//@Disabled
public class Drivetrain extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    //DcMotor leftMotor;
    //DcMotor rightMotor;
    DcMotor leftBackMotor;
    DcMotor rightBackMotor;
    DcMotor frontLift;
    DcMotor backLift;
    Servo frontServo;
    Servo backServo;
    Servo leftBackServo;
    Servo rightBackServo;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        /*leftMotor = hardwareMap.dcMotor.get("Left_Motor");
        rightMotor = hardwareMap.dcMotor.get("Right_Motor");*/
        leftBackMotor = hardwareMap.dcMotor.get("Left_Back_Motor");
        rightBackMotor = hardwareMap.dcMotor.get("Right_Back_Motor");

        /*leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);*/
        rightBackMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        //leftBackMotor.setPower(0.3);
        //rightBackMotor.setPower(0.3);
        leftBackMotor.setPower(-gamepad1.left_stick_y/2.0);
        rightBackMotor.setPower(-gamepad1.right_stick_y/2.0);

        frontLift = hardwareMap.dcMotor.get("Front_Lift");
        backLift = hardwareMap.dcMotor.get("Back_Lift");

        frontServo = hardwareMap.servo.get("Front_Servo");
        frontServo.setPosition(0.1);
        //leftServo.setPosition(0.7);
        backServo = hardwareMap.servo.get("Back_Servo");
        //rightServo.setPosition(0.3);
        backServo.setPosition(0.7);
        leftBackServo = hardwareMap.servo.get("Left_Back_Servo");
        leftBackServo.setPosition(0.75);
        rightBackServo= hardwareMap.servo.get("Right_Back_Servo");
        //rightBackServo.setPosition(1);
        rightBackServo.setPosition(0.05);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()){

            /*leftMotor.setPower(-gamepad1.left_stick_y);
            rightMotor.setPower(-gamepad1.right_stick_y);*/
            leftBackMotor.setPower(-gamepad1.left_stick_y);
            rightBackMotor.setPower(-gamepad1.right_stick_y);

            if(gamepad2.dpad_up){
                frontLift.setPower(1);
            } else {
                frontLift.setPower(0);
            }

            if(gamepad2.dpad_down){
                frontLift.setPower(-1);
            } else {
                frontLift.setPower(0);
            }

            if(gamepad2.y){
                backLift.setPower(1);
            } else {
                backLift.setPower(0);
            }

            if(gamepad2.a){
                backLift.setPower(-1);
            } else {
                backLift.setPower(0);
            }

            if(gamepad2.left_bumper) {
                frontServo.setPosition(0.67);
                backServo.setPosition(0.31);
            }

            if(gamepad2.left_trigger != 0) {
                frontServo.setPosition(0.30);
                backServo.setPosition(0.56);
            }

            if(gamepad2.right_bumper){
                leftBackServo.setPosition(0.22);
                rightBackServo.setPosition(0.39);
            }

            if(gamepad2.right_trigger != 0){
                leftBackServo.setPosition(0.5);
                rightBackServo.setPosition(0.1);
            }
        }
    }
}
