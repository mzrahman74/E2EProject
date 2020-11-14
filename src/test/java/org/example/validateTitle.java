package org.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

import java.io.IOException;

public class validateTitle extends base {
   public WebDriver driver;
    private static Logger log = LogManager.getLogger(validateTitle.class.getName());
@BeforeTest
public void initialize() throws IOException {
    driver = initializeDriver();
    log.info("Driver is installed. ");
    driver.get(prop.getProperty("url"));
    log.info("Navigated to Home page");
}
    @Test
    public void verify_validateTitle() throws IOException {

      LandingPage l = new LandingPage(driver);
      String title = "Featured Courses";
      Assert.assertEquals(l.getFeatured().getText(),title);
      Assert.assertTrue(l.getNavigationBar());
    log.info("Successfully validated text message.");

    }

    @AfterTest
    public void teardown(){
    driver.close();
    }


  }
