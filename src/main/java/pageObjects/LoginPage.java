package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.id("user_email");
    By password = By.xpath("//input[@id='user_password']");
    By login    = By.cssSelector("input[name='commit']");
    By forgotPassword = By.linkText("Forgot Password?");


    public WebElement getUserName(){
        return driver.findElement(username);

    }

    public WebElement getPassword(){
        return driver.findElement(password);
    }
    public WebElement getLogIn(){
        return driver.findElement(login);
    }

    public PasswordReset getForgotPassword(){
         driver.findElement(forgotPassword).click();
        PasswordReset pr = new PasswordReset(driver);
        return pr;
    }

}
