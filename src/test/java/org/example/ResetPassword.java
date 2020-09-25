package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PasswordReset;
import resources.base;

import java.io.IOException;

public class ResetPassword extends base {
    public WebDriver driver;
    private static Logger log = LogManager.getLogger(ResetPassword.class.getName());
    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is installed.");
        driver.get(prop.getProperty("url"));
        log.info("Password reset page.");

    }

    @Test
    public void verifyPasswordResetPage() throws IOException {
    LandingPage l = new LandingPage(driver);
    LoginPage lp = l.getLogin();
   PasswordReset pr =lp.getForgotPassword();
   pr.getUserEmail().sendKeys("abc@gmail.com");
   pr.getInstruction().click();

    }

    @AfterTest
    public void teardown(){
        driver.close();
    }

}
