package methodsAndLocators;

import org.openqa.selenium.By;

public interface Locators {

    By lLoginButton = By.cssSelector("a[title='Giriş Yap']");
    By lInputEmail=By.cssSelector("input[id='email']");
    By lInputPassword=By.cssSelector("input[id='pass']");
    By lInputLogin=By.cssSelector("input[name='login']");
    By lLoginWithFacebook= By.cssSelector("div[class='facebook_large medium facebookBtn  btnLogin']");
    By lMyAccount = By.cssSelector("a[title='Hesabım']");
    By lSearchInput=By.cssSelector("input[id='searchData']");
    By lProductNames=By.cssSelector("h3[class='productName']");
    By lPage2Button=By.xpath("//a[text()='2']");
    By lProductThirdFavIcon=By.xpath("(//span[@title='Favorilere ekle'])[3]");
    By lProductThirdName=By.xpath("(//h3[@class='productName'])[3]");
    By lMyFavoriesAndLists=By.cssSelector("a[title='Favorilerim / Listelerim']");
    By lMyFavorits=By.xpath("(//h4[@class='listItemTitle'])[1]");
    By lProductNameInMyFavorite=By.xpath("(//h3[@class='productName '])[1]");
    By lDeleteFromFav=By.cssSelector("span[class='deleteProFromFavorites']");
    By lOkButton=By.cssSelector("span[class='btn btnBlack confirm']");
    By lLogout=By.cssSelector("a[class='logoutBtn']");




}
