package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

import java.io.IOException;

public class HomePage extends base {
  public WebDriver driver;
  private static Logger log = LogManager.getLogger(HomePage.class.getName());

  @BeforeTest
  public void initialize() throws IOException {
    driver = initializeDriver();
    
  }

  @Test(dataProvider = "getData")
  public void basePageNavigation(String Username, String Password)  {
    driver.get(prop.getProperty("url"));
    LandingPage l = new LandingPage(driver);
    LoginPage lp = l.getLogin();
    lp.getUserName().sendKeys(Username);
    lp.getPassword().sendKeys(Password);
    lp.getLogIn().click();
    log.info("User successfully log in not successful.");



  }

  @DataProvider
  public Object[][] getData() {
    // Row stands for how many different data types  should run
    // coloumn stands for how many values per each test
    Object[][] data = new Object[2][2];
    // 0 th row
    data[0][0] = "username";
    data[0][1] = "password";


    // 1st row
    data[1][0] = "username1";
    data[1][1] = "Password1";


    return data;
  }

  @AfterTest
  public void teardown() {

    driver.close();
  }
}
