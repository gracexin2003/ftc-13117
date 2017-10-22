package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.*;

@TeleOp(name="Drivetrain", group="Linear Opmode")
//@Disabled
public class Drivetrain extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor leftBackMotor;
    DcMotor rightBackMotor;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftMotor = hardwareMap.dcMotor.get("Left_Motor");
        rightMotor = hardwareMap.dcMotor.get("Right_Motor");
        leftBackMotor = hardwareMap.dcMotor.get("Left_Back_Motor");
        rightBackMotor= hardwareMap.dcMotor.get("Right_Back_Motor");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            leftMotor.setPower(-gamepad1.left_stick_y);
            rightMotor.setPower(-gamepad1.right_stick_y);
            leftBackMotor.setPower(-gamepad1.left_stick_y);
            rightBackMotor.setPower(-gamepad1.right_stick_y);
        }
    }
}
