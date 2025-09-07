package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
public class arm {
    private static Servo leftServo;
    private static Servo rightServo;
    private static Gamepad Driver1;
    private static double scorePosition = 0;
    private static double intakePosition = 0.40;

    public arm(OpMode opMode) {
        Driver1 = opMode.gamepad1;
        leftServo = (Servo) opMode.hardwareMap.get("leftArm");
        rightServo = (Servo) opMode.hardwareMap.get("rightArm");


        leftServo.setDirection(Servo.Direction.REVERSE);
        rightServo.setDirection(Servo.Direction.FORWARD);
        armServo(scorePosition, scorePosition);
//        opMode.time
    }

    public static void teleOp() throws InterruptedException {
        if (Driver1.dpad_left) armServo(scorePosition, scorePosition);
        else if (Driver1.x) armServo(scorePosition, scorePosition);
        else if (Driver1.b) armServo(scorePosition, scorePosition);
        else if (Driver1.a) armServo(intakePosition, intakePosition);
        else if (Driver1.y) armServo(scorePosition,scorePosition);

        //for(int i=0; i<=7;i++){
        // wait();
    }



    public static void armServo(double setPositionRight, double setPositionLeft) {
        rightServo.setPosition(setPositionRight);
        leftServo.setPosition(setPositionLeft);
    }
}