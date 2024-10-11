import Pages.US_402_405_406_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import Utility.MyFunc;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_402 extends BaseDriver {

    @Test(dataProvider = "userPassword", groups = "Smoke Test")
    public void loginPositive(String username, String password, boolean expectedResult) {
        US_402_405_406_POM element = new US_402_405_406_POM();

        driver.get(ConfigReader.getProperty("URL"));

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

        MyFunc.scrollElement(element.exploreOpenMRS2);
        wait.until(ExpectedConditions.visibilityOf(element.exploreOpenMRS2));
        element.exploreOpenMRS2.click();

        wait.until(ExpectedConditions.elementToBeClickable(element.enterOpenMRSDemo));
        element.enterOpenMRSDemo.click();

        if (element.loginText.isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOf(element.username));
            element.username.sendKeys(username);

            wait.until(ExpectedConditions.visibilityOf(element.password));
            element.password.sendKeys(password);

            wait.until(ExpectedConditions.elementToBeClickable(element.inpatientWard));
            element.inpatientWard.click();

            wait.until(ExpectedConditions.elementToBeClickable(element.logInButton));
            element.logInButton.click();
        }

        if (!expectedResult) {
            Assert.assertTrue(element.errorMessage.getText().contains("Please try again."));
        } else {
            Assert.assertTrue(element.loginControl.getText().contains("Logged in as Super User"));
        }

        if (!expectedResult) {
            driver.get(ConfigReader.getProperty("URL"));
        }
    }

    @DataProvider
    Object[][] userPassword() {
        Object[][] userData = {
                {"Merve", "Team61", false},
                {"Ümmühan", "Team62", false},
                {"Sefa", "Team63", false},
                {"Serkan", "Team64", false},
                {"Abdulkerim", "Team65", false},
                {"Nigar", "Team66", false},
                {ConfigReader.getProperty("username"), ConfigReader.getProperty("password"), true}
        };
        return userData;
    }
}