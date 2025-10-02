package org.firstinspires.ftc.Decode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.Decode.drive.Drive;
import org.firstinspires.ftc.Decode.subsystems.Intake.FlyWheel;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        FlyWheel flyWheel = new FlyWheel(this);
        Drive drive = new Drive(this);

    }
}
