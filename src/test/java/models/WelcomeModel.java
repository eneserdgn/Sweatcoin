package models;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class WelcomeModel {

    public static By logo = AppiumBy.className("com.horcrux.svg.PathView");
    public static By description = AppiumBy.className("android.widget.TextView");
    public static By googleButton = AppiumBy.id("signUpButton");
    public static By alreadyHaveAccount = AppiumBy.xpath("//android.widget.TextView[2]");
    public static By termsAndPrivacy = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").index(4)");

}
