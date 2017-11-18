package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class Autonomous extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor leftBackMotor;
    private DcMotor rightBackMotor;
    private DcMotor backLift;
    private Servo leftBackServo;
    private Servo rightBackServo;
    private Servo bottomServo;
    private Servo topServo;

    Servo servo1;
    Servo servo2;
    double servoPosition1 = 0.0;
    double servoPosition2 = 0.0;

    public enum Program {red1, red2, blue1, blue2, none}

    Program side = Program.red1;

    public void setProgram(Program side) {
        this.side = side;
    }

    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        if (this.side == Program.none)
            throw new RuntimeException("Set side before running.");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        double servoPosition = 0.5;

        leftBackMotor = hardwareMap.dcMotor.get("Left_Back_Motor");
        rightBackMotor = hardwareMap.dcMotor.get("Right_Back_Motor");

        leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);

        backLift = hardwareMap.dcMotor.get("Back_Lift");

        leftBackServo = hardwareMap.servo.get("Left_Back_Servo");
        leftBackServo.setPosition(0.25);
        rightBackServo = hardwareMap.servo.get("Right_Back_Servo");
        rightBackServo.setPosition(0.4);
        bottomServo = hardwareMap.servo.get("Bottom_Servo");
        topServo = hardwareMap.servo.get("Top_Servo");

        double power = 0.5;

        waitForStart();
        runtime.reset();

        backLift.setPower(0.2);

        sleep(100);

        bottomServo.setPosition(0);
        topServo.setPosition(0.8);

        power = 0;

        leftBackMotor.setPower(power);
        rightBackMotor.setPower(power);

        sleep(2000);

        power = 0.5;

        leftBackMotor.setPower(-power);
        rightBackMotor.setPower(-power);

        sleep(500);

        power = 0;

        leftBackMotor.setPower(power);
        rightBackMotor.setPower(power);

        sleep(1000);

        bottomServo.setPosition(1);
        topServo.setPosition(0.0);

        power = 0.4;

        leftBackMotor.setPower(-power);
        rightBackMotor.setPower(-power);

        sleep(2500);

        leftBackServo.setPosition(0.5);
        rightBackServo.setPosition(0.1);

        power = 0.3;

        leftBackMotor.setPower(power);
        rightBackMotor.setPower(power);

        sleep(100);

        power = 0.5;

        backLift.setPower(-power);

        sleep(100);
    }
}
