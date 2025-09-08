package org.firstinspires.ftc.ITD.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.ITD.drive.DriverCentricDrive;
import org.firstinspires.ftc.ITD.subsystems.arm;
import org.firstinspires.ftc.ITD.subsystems.claw;
import org.firstinspires.ftc.ITD.subsystems.slide;

@TeleOp
public class DriverCentricTeleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        slide slide = new slide(this);
        DriverCentricDrive driverCentricDrive= new DriverCentricDrive(this);
        claw claw = new claw(this);
        arm arm = new arm(this);
        waitForStart();
        while (opModeIsActive()) {
            driverCentricDrive.driverCentric();
            claw.teleOp();
            slide.teleOp();
            org.firstinspires.ftc.ITD.subsystems.arm.teleOp();
        }
    }
}
