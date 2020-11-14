package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordReset {
    WebDriver driver;

    public PasswordReset(WebDriver driver) {
        this.driver = driver;
    }


    By useremail = By.id("user_email");
    By instruction = By.cssSelector("input[name='commit']");

    public WebElement getUserEmail(){
        return driver.findElement(useremail);
    }

    public WebElement getInstruction(){
        return driver.findElement(instruction);
    }
}

