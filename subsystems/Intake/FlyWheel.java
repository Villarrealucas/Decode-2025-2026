package org.firstinspires.ftc.Decode.subsystems.Intake;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FlyWheel {
    private DcMotor run;
    private HardwareMap hardwareMap;
    private Gamepad Driver2;
    private Gamepad Driver1;

    public FlyWheel(OpMode opMode){
        Driver1 = opMode.gamepad1;
        Driver2 = opMode.gamepad2;
        hardwareMap = opMode.hardwareMap;

        run = hardwareMap.get(DcMotor.class,"run");
        run.setDirection(DcMotorSimple.Direction.FORWARD);
        run.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        run.setTargetPosition(0);

        }
        public void teleOp(){
            while (Driver1.a) Start();
        }

    private void Start() {
        run.setPower(1);

    }
}
