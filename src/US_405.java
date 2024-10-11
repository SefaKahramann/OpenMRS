import Pages.US_402_405_406_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import Utility.MyFunc;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_405 extends BaseDriver {

    @Test(groups = "Smoke Test")
    public void myAccount() {
        US_402_405_406_POM element = new US_402_405_406_POM();
        Actions action = new Actions(driver);

        driver.get(ConfigReader.getProperty("URL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL")));

        do {
            if (!element.languageButton.getText().contains("EN")) {
                wait.until(ExpectedConditions.elementToBeClickable(element.languageButton));
                element.languageButton.click();

                wait.until(ExpectedConditions.visibilityOf(element.selectEnglish));
                MyFunc.jsClick(element.selectEnglish);
            }

        } while (!element.languageButton.getText().contains("EN"));

        wait.until(ExpectedConditions.elementToBeClickable(element.demoButton));
        element.demoButton.click();

        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("demoURL")));
        MyFunc.scrollElement(element.enterOpenMRSDemo);
        wait.until(ExpectedConditions.visibilityOf(element.enterOpenMRSDemo));
        element.enterOpenMRSDemo.click();

        if (element.loginText.isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOf(element.username));
            element.username.sendKeys(ConfigReader.getProperty("username2"));

            wait.until(ExpectedConditions.visibilityOf(element.password));
            element.password.sendKeys(ConfigReader.getProperty("password"));

            int randomLocations = (int) (Math.random() * element.lacationList.size());
            wait.until(ExpectedConditions.elementToBeClickable(element.lacationList.get(randomLocations)));
            element.lacationList.get(randomLocations).click();

            wait.until(ExpectedConditions.elementToBeClickable(element.logInButton));
            element.logInButton.click();
        }

        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("homePageURL")));
        Assert.assertTrue(element.loginControl.getText().contains("Logged in as Super User"));

        wait.until(ExpectedConditions.visibilityOf(element.adminFunc));
        action.moveToElement(element.adminFunc).perform();
        wait.until(ExpectedConditions.elementToBeClickable(element.myAccountLink));
        element.myAccountLink.click();

        wait.until(ExpectedConditions.elementToBeClickable(element.changePasswordButton));
        element.changePasswordButton.click();
        Assert.assertTrue(element.changePassContText.getText().contains("Change"));

        wait.until(ExpectedConditions.elementToBeClickable(element.myAccountLink));
        element.myAccountLink.click();

        wait.until(ExpectedConditions.elementToBeClickable(element.myLanguageButton));
        element.myLanguageButton.click();
        Assert.assertTrue(element.myLanguageText.getText().contains("Language"));

        wait.until(ExpectedConditions.elementToBeClickable(element.myAccountLink));
        element.myAccountLink.click();
    }
}
