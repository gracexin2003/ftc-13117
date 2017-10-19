/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * In this program, the color sensor is on the right of the stick attached to the servos,
 * with the front being the right side and the back being the left side.
 */

@TeleOp(name="Jewel_Red", group="Linear Opmode")
//@Disabled
public class Jewel_Red extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    ColorSensor cs;
    Color c;

    Servo servo;
    double servoPosition = 0.0;

    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor leftBackMotor;
    DcMotor rightBackMotor;

    //This program assumes that the side of the robot that is facing the jewels has the color sensor.
    //The color sensor should be sensing the jewel on the right side of the separator.
    
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        cs = hardwareMap.colorSensor.get("Color Sensor");
        cs.enableLed(true);

        servo = hardwareMap.servo.get("servo");
        servo.setPosition(servoPosition);

        waitForStart();
        runtime.reset();

        servoPosition = 0.5;
        servo.setPosition(servoPosition);

        leftMotor = hardwareMap.dcMotor.get("Left_Motor");
        rightMotor = hardwareMap.dcMotor.get("Right_Motor");
        leftBackMotor = hardwareMap.dcMotor.get("Left_Back_Motor");
        rightBackMotor= hardwareMap.dcMotor.get("Right_Back_Motor");

        if (cs.red() > 200) { // turn left
            leftMotor.setPower(0.0);
            rightMotor.setPower(0.5);
            leftBackMotor.setPower(0.0);
            rightBackMotor.setPower(0.5);
        }else{ // turn right
            leftMotor.setPower(0.5);
            rightMotor.setPower(0.0);
            leftBackMotor.setPower(0.5);
            rightBackMotor.setPower(0.0);
        }

        servoPosition = 0.5;
        servo.setPosition(servoPosition);
    }
}
