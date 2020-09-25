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

public class validateNavigationBar extends base {
  public WebDriver driver;
  private static Logger log = LogManager.getLogger(validateTitle.class.getName());
  @BeforeTest
  public void initialize() throws IOException {
    driver = initializeDriver();
    driver.get(prop.getProperty("url"));
  }

  @Test
  public void verify_NavigationBar() throws IOException {

    LandingPage l = new LandingPage(driver);
    Assert.assertTrue(l.getNavigationBar());
    log.info("Navigation bar displayed.");

  }

  @AfterTest
  public void teardown() {
    driver.close();
  }
}
