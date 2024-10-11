import Pages.US_403_408_409_410_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import Utility.MyFunc;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_403 extends BaseDriver {

    @Test(groups = "Smoke Test")
    public void logOut() {
        US_403_408_409_410_POM element = new US_403_408_409_410_POM();

        driver.get(ConfigReader.getProperty("URL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL")));

        do {
            if (!element.languageBtn.getText().contains("EN")) {
                wait.until(ExpectedConditions.elementToBeClickable(element.languageBtn));
                element.languageBtn.click();

                wait.until(ExpectedConditions.visibilityOf(element.languageEn));
                MyFunc.jsClick(element.languageEn);
            }
        } while (!element.languageBtn.getText().contains("EN"));

        wait.until(ExpectedConditions.elementToBeClickable(element.demoBtn));
        element.demoBtn.click();

        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("demoURL")));
        MyFunc.scrollElement(element.OpenMRS2DemoBtn);
        element.OpenMRS2DemoBtn.click();

        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("loginURL")));
        wait.until(ExpectedConditions.elementToBeClickable(element.username));
        element.username.sendKeys(ConfigReader.getProperty("username"));

        wait.until(ExpectedConditions.elementToBeClickable(element.password));
        element.password.sendKeys(ConfigReader.getProperty("password"));

        int randomLocation = (int) (Math.random() * element.locations.size());
        String keyWordStr = element.locations.get(randomLocation).getText();

        wait.until(ExpectedConditions.elementToBeClickable(element.locations.get(randomLocation)));
        element.locations.get(randomLocation).click();

        wait.until(ExpectedConditions.elementToBeClickable(element.logInBtn));
        element.logInBtn.click();
        Assert.assertTrue(element.logInControl.getText().contains(keyWordStr));

        wait.until(ExpectedConditions.elementToBeClickable(element.logOutBtn));
        element.logOutBtn.click();
    }
}
