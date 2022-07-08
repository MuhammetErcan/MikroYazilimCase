package testClass;

import methodsAndLocators.HomepageAndMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class TestClass extends HomepageAndMethods {

    @Test(testName = "Go to homepage",priority = 0)
    public void goToHomePage(){
        goToHomePageMethod();
    }


    @Test(testName = "Login", priority = 1)
    public void login(){
        loginMethod("saribeyaz838@gmail.com","saribeyaz838@");
    }

    @Test(testName = "Search Product", priority = 2)
    public void searchProduct(){
        searchProduckMethod("Iphone");
    }

    @Test(testName = "Go to page 2", priority = 3)
    public void goToPage2(){
        goToPage2Method();
    }

    @Test(testName = "Add favorite", priority = 4)
    public void addFavorite(){
        addFavoriteMethod();
    }

    @Test(testName = "Remove favorite", priority = 5)
    public void removeFavorite(){
        removeFavoriteMethod();
    }

    @Test(testName = "Logout", priority = 6)
    public void logout(){
        logoutMethod();
    }



}
