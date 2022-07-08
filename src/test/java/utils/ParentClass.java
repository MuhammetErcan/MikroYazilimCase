package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestNGListener;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static methodsAndLocators.Locators.lMyAccount;


public class ParentClass {

    protected    WebDriver driver;
    protected    WebDriverWait wait;

    public ParentClass(){
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToUrl(String url){
        driver.get(url);
    }

    public void clickTo(By locater){
        wait.until(ExpectedConditions.elementToBeClickable(locater)).click();
    }


    public void sendKeysTo(By locater, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).sendKeys(text);
    }


    public void waitFor(By locater, WaitConditions waitConditions){
        switch (waitConditions){
            case exist:
                wait.until(ExpectedConditions.presenceOfElementLocated(locater));
                break;
            case clickable:
                wait.until(ExpectedConditions.elementToBeClickable(locater));
                break;
            case visible:
                wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
                break;
            case invisible:
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locater));
        }
    }


    public void scrollLocator(By locator){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));
    }

    public void scrollLocator(By locator, Boolean bool){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView("+ bool+");",driver.findElement(locator));
    }

    public void screenShotBySelenium() throws IOException {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        String scrName="ScreenShot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        TakesScreenshot scr= (TakesScreenshot) driver ;
        File scrShot=scr.getScreenshotAs(OutputType.FILE);
        File destScr=new File("ScreenShots\\" + scrName+ ".png");

        FileUtils.copyFile(scrShot,destScr);

        Reporter.log("<br><img src='" + destScr + "' height='400' width='400'/><br> ");
        Reporter.log("<a href="+destScr+"></a>");



    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void actionLocator(By locator){
        Actions builder = new Actions(driver);
        Action build = builder.moveToElement(driver.findElement(locator)).build();
        build.perform();
    }



    @AfterSuite
    public void afterSuite(){
        Driver.quitDriver();
    }


}