package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.Collections;

public class ElementHelper {
    static boolean isWeb = false;

    public static WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    Logger logger = LoggerFactory.getLogger(getClass());

    public void scroll(By by) {
        if (isWeb) {
            JavascriptExecutor j = (JavascriptExecutor) driver;
            j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", driver.findElement(by));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void click(By by) {
        try {
            scroll(by);
            wait.until(ExpectedConditions.presenceOfElementLocated(by)).click();
            logger.info("\u001B[32m" + "        click to :" + by + "\u001B[0m");
        } catch (Exception e) {
            logger.error("\u001B[31m" + "        click to :" + by + "\u001B[0m");
            throw e;
        }
    }

    public void clickWithJS(By by) {
        try {
            scroll(by);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(by));
            logger.info("\u001B[32m" + "        click to :" + by + "\u001B[0m");
        } catch (Exception e) {
            logger.error("\u001B[31m" + "        click to :" + by + "\u001B[0m");
            throw e;
        }
    }

    public void check(By by) {
        try {
            scroll(by);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            logger.info("\u001B[32m" + "        check to :" + by + "\u001B[0m");
        } catch (Exception e) {
            logger.error("\u001B[31m" + "        check to :" + by + "\u001B[0m");
            throw e;
        }
    }

    public void write(By by, String text) {
        try {
            scroll(by);
            wait.until(ExpectedConditions.presenceOfElementLocated(by)).sendKeys(text);
            logger.info("\u001B[32m" + "        write " + text + " to :" + by + "\u001B[0m");
        } catch (Exception e) {
            logger.error("\u001B[31m" + "        write to :" + by + "\u001B[0m");
            throw e;
        }
    }

    public void writeWithoutElement(String text) {
        try {
            new Actions(driver).sendKeys(text).build().perform();
            logger.info("\u001B[32m" + "        write without element" + text + "\u001B[0m");
        } catch (Exception e) {
            logger.error("\u001B[32m" + "        write without element" + text + "\u001B[0m");
            throw e;
        }
    }

    public void checkText(By by, String text) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
            logger.info("\u001B[32m" + "        check text" + text + " to :" + by + "\u001B[0m");
        } catch (Exception e) {
            logger.error("\u001B[31m" + "        click to :" + by + "\u001B[0m");
            throw e;
        }
    }

    public void checkTextWithoutWaitText(By by, String text) {
        try {
            Assert.assertEquals(driver.findElement(by).getText().replaceAll("\\s+", ""), text.replaceAll("\\s+", ""));
            logger.info("\u001B[32m" + "        check text" + text + " to :" + by + "\u001B[0m");
        } catch (Exception e) {
            logger.error("\u001B[31m" + "        click to :" + by + "\u001B[0m");
            throw e;
        }
    }

    public void checkAttribute(By by, String attr, String text) {
        try {
            wait.until(ExpectedConditions.attributeToBe(by, attr, text));
            logger.info("\u001B[32m" + "        check text" + text + " to :" + by + "\u001B[0m");
        } catch (Exception e) {
            logger.error("\u001B[31m" + "        click to :" + by + "\u001B[0m");
            throw e;
        }
    }


    public void clickElementRightSide(By by) {
        int x = driver.findElement(by).getLocation().getX();
        int y = driver.findElement(by).getLocation().getY();
        int width = driver.findElement(by).getRect().getWidth();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x + width - 5, y + 5));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        DriverFactory.getDriver().perform(Collections.singletonList(swipe));
    }

}
