package Repoting;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Base.BaseDriver;

public final class ExtentLogger extends BaseDriver {

    public static void pass(String message){
        ExtentManager.getExtentTest().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
        ExtentManager.getExtentTest().pass("ScreenShot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
    }
    public static void fail(String message){
        ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
        ExtentManager.getExtentTest().fail("ScreenShot", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
    }
    public static void skip(String message){
        ExtentManager.getExtentTest().skip(MarkupHelper.createLabel(message, ExtentColor.ORANGE));
        ExtentManager.getExtentTest().skip("ScreenShot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
    }
}
