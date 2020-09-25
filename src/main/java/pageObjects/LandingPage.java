package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

  By signin =By.cssSelector("a[href*='sign_in']");
  By features = By.cssSelector("div[class='text-center'] h2");
  By navigation = By.cssSelector(".nav.navbar-nav.navbar-right");


//    By signin =By.cssSelector("//span[contains(text(),'Login')]");

    public LoginPage getLogin(){
         driver.findElement(signin).click();
         LoginPage lp = new LoginPage(driver);
         return lp;
    }
    public WebElement getFeatured(){
        return driver.findElement(features);
    }
    public boolean getNavigationBar(){
        return driver.findElement(navigation).isDisplayed();
    }




}

