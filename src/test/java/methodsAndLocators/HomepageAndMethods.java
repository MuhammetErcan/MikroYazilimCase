package methodsAndLocators;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestNGListener;
import utils.ParentClass;
import utils.WaitConditions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import static methodsAndLocators.Locators.*;

public class HomepageAndMethods extends ParentClass  {
    String homePageId;
    {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
    }

    public void goToHomePageMethod(){
        String homePageUrl="https://www.n11.com/";
        goToUrl(homePageUrl);
        Assert.assertEquals(driver.getCurrentUrl(),homePageUrl);
        try {
            screenShotBySelenium();
        } catch (IOException e) {
            e.printStackTrace();
        }
        homePageId=driver.getWindowHandle();
    }

    public void loginMethod(String username, String password) {
        clickTo(lLoginButton);
        String loginPageID = driver.getWindowHandle();
        clickTo(lLoginWithFacebook);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowId : windowHandles) {
            if (!windowId.equals(loginPageID)) {
                driver.switchTo().window(windowId);
            }
        }
        sendKeysTo(lInputEmail,username);
        sendKeysTo(lInputPassword, password );
        clickTo(lInputLogin);
        driver.switchTo().window(homePageId);
        waitFor(lMyAccount,WaitConditions.visible);
        try {
            screenShotBySelenium();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void searchProduckMethod(String productName){
        clickTo(lSearchInput);
        sendKeysTo(lSearchInput, productName+ Keys.ENTER);

        List<WebElement> productNamesList=driver.findElements(lProductNames);
        for (WebElement element : productNamesList) {
            Assert.assertTrue(element.getText().toLowerCase(Locale.ROOT).contains(productName.toLowerCase(Locale.ROOT)));
        }
        try {
            screenShotBySelenium();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToPage2Method(){
        scrollLocator(lPage2Button,false);
        clickTo(lPage2Button);
        Assert.assertTrue(driver.getCurrentUrl().contains("pg=2"));
        try {
            screenShotBySelenium();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addFavoriteMethod(){
        String productThirdName=driver.findElement(lProductThirdName).getText();
        clickTo(lProductThirdFavIcon);
        try {
            screenShotBySelenium();
        } catch (IOException e) {
            e.printStackTrace();
        }
        waitFor(lMyAccount,WaitConditions.visible);
        actionLocator(lMyAccount);
        clickTo(lMyFavoriesAndLists);
        sleep(3000);
        clickTo(lMyFavorits);
        String productNameInMyFavorite=driver.findElement(lProductNameInMyFavorite).getText();
        Assert.assertEquals(productThirdName.toLowerCase(Locale.ROOT),productNameInMyFavorite.toLowerCase(Locale.ROOT));
        Assert.assertTrue(driver.getCurrentUrl().contains("favorilerim"));
        try {
            screenShotBySelenium();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeFavoriteMethod(){
        clickTo(lDeleteFromFav);
        clickTo(lOkButton);
        waitFor(lProductNameInMyFavorite, WaitConditions.invisible);
        try {
            screenShotBySelenium();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logoutMethod(){
        actionLocator(lMyAccount);
        clickTo(lLogout);
        try {
            screenShotBySelenium();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

