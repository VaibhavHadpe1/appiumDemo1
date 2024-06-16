package StepDefinations;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseStep
{
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        //start emulator
        LaunchEmulator.startEmulator();

        //Start Appium server
        AppiumServer.startAppium();

        Thread.sleep(2000);
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("Pixel_6a_API_33")
                .setPlatformVersion("13.0")
                .setUdid("emulator-5554")
                .setAppActivity("com.aciana.docisn.MainActivity")
                .setAppPackage("com.aciana.docisn")
                .setAutomationName("UiAutomator2")
                .setPlatformName("Android")
                .setAutoGrantPermissions(true)
                .setNoReset(true)
                .setNewCommandTimeout(Duration.ofSeconds(30));
        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement docisnApp=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Docisn']"));

//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.elementToBeClickable(docisnApp));

        Thread.sleep(5000);
        docisnApp.click();

        Thread.sleep(5000);
        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
        jsDriver.executeScript("mobile: terminateApp", ImmutableMap.of("appId", "com.aciana.docisn"));

        //Stop Appium server
        AppiumServer.stopAppium();

    }

}
