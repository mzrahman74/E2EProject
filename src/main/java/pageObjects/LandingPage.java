package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

  By signin =By.cssSelector("a[class='theme-btn register-btn']");
  By features = By.xpath(" //h2[contains(text(),'Featured Courses')]");
  By navigation = By.xpath("//header/div[2]/div[1]/div[1]/div[2]/nav[1]/div[2]/ul[1]");


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

