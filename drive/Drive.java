package org.firstinspires.ftc.Decode.drive;


import android.annotation.SuppressLint;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {

    private DcMotor leftFront,leftBack,rightFront,rightBack;
    private Gamepad Driver1;
     double speed= 85;


     public Drive (OpMode opMode){
         Driver1 = opMode.gamepad1;
         HardwareMap hardwareMap = opMode.hardwareMap;
         leftFront = hardwareMap.get(DcMotor.class,"leftFornt");
         leftBack = hardwareMap.get(DcMotor.class,"leftBack");
         rightFront = hardwareMap.get(DcMotor.class,"rightFront");
         rightBack = hardwareMap.get(DcMotor.class,"rightBack");

         leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
         leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
         rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
         rightBack.setDirection(DcMotorSimple.Direction.FORWARD);

         leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
     }
    @SuppressLint("NotConstructor")
    public void Drive ()  {
         if (Driver1.left_bumper) {
             speed = .5;
         }
             else{
                 speed = 1;
         }
        double y = -Driver1.left_stick_y;
        double x = Driver1.left_stick_x * 1.1;
        double rx = Driver1.right_stick_x;

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator * speed;
        double backLeftPower = (y - x + rx) / denominator* speed;
        double frontRightPower = (y - x - rx)  / denominator* speed;
        double backRightPower = (y + x - rx) / denominator* speed;

        leftFront.setPower(frontLeftPower);
        leftBack.setPower(backLeftPower);
        rightFront.setPower(frontRightPower);
        rightBack.setPower(backRightPower);
    }
}


