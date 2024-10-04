package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;
    public WebDriverWait wait;
    public static Logger logger= LogManager.getLogger();

    @BeforeClass
    public void beforeClass(){
        switch (ConfigReader.getProperty("browser").toLowerCase()){
            case "firefox":driver=new FirefoxDriver(); break;
            case "edge":driver=new EdgeDriver(); break;
            case "chrome":driver = new ChromeDriver();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get(ConfigReader.getProperty("URL"));
    }

    @AfterClass
    public void afterClass() {
        MyFunc.Wait(2);
        driver.quit();
    }
}
