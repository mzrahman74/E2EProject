package resources;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


    public   class base {
        public WebDriver driver;
        public Properties prop;
        public WebDriver initializeDriver() throws IOException {

            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/main/java/resources/data.properties");
            prop.load(fis);
            FileOutputStream fos = new FileOutputStream("src/main/java/resources/data.properties");
            prop.store(fos, null);
            prop.setProperty("browser", "firefox");
            // mvn test -Dbrowser = firefox
           // String browserName = System.getProperty("browser");
            String browserName = prop.getProperty("browser");

            if(browserName.equals("firefox")) {
                 driver = new FirefoxDriver();

            } else if (browserName.equals("safari") ) {

                 driver = new SafariDriver();

            } else if (browserName.equals("chrome") ) {
                driver = new ChromeDriver();
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return driver;



        }
        public String getScreenShotPath(String testcaseName, WebDriver driver) throws IOException {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source =ts.getScreenshotAs(OutputType.FILE);
            String destinationFile = System.getProperty("user.dir") + "/reports/"+testcaseName+ ".png";
            FileUtils.copyFile(source, new File(destinationFile));
            return destinationFile;
        }
    }

