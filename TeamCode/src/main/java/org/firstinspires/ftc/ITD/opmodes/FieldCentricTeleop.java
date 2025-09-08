package org.firstinspires.ftc.ITD.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.ITD.drive.FieldCentricDrive;
import org.firstinspires.ftc.ITD.subsystems.arm;
import org.firstinspires.ftc.ITD.subsystems.claw;
import org.firstinspires.ftc.ITD.subsystems.slide;

@TeleOp
public class FieldCentricTeleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        slide slide = new slide(this);
        FieldCentricDrive fieldCentricDrive= new FieldCentricDrive(this);
        claw claw = new claw(this);
        arm arm = new arm(this);
        waitForStart();
        while (opModeIsActive()) {
            fieldCentricDrive.fieldCentric();
            claw.teleOp();
            slide.teleOp();
            arm.teleOp();
        }
    }
}
