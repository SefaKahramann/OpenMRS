import Pages.US_401_404_407_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import Utility.MyFunc;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_401 extends BaseDriver {

    @Test(dataProvider = "userData", groups = "Smoke Test")
    public void checkingLoginErrorsSystem(String username, String password, boolean expectedResult) {
        US_401_404_407_POM locators = new US_401_404_407_POM();

        driver.get(ConfigReader.getProperty("URL"));

        do {
            if (!locators.languageButton.getText().contains("EN")) {
                wait.until(ExpectedConditions.elementToBeClickable(locators.languageButton));
                locators.languageButton.click();

                wait.until(ExpectedConditions.visibilityOf(locators.languageEnglish));
                MyFunc.jsClick(locators.languageEnglish);
            }
        } while (!locators.languageButton.getText().contains("EN"));

        wait.until(ExpectedConditions.elementToBeClickable(locators.demoButton));
        locators.demoButton.click();

        MyFunc.scrollElement(locators.exploreOpenMrs2);
        wait.until(ExpectedConditions.visibilityOf(locators.exploreOpenMrs2));
        locators.exploreOpenMrs2.click();

        wait.until(ExpectedConditions.elementToBeClickable(locators.enterOpenMrs2));
        locators.enterOpenMrs2.click();

        wait.until(ExpectedConditions.visibilityOf(locators.userName));
        locators.userName.sendKeys(username);

        wait.until(ExpectedConditions.visibilityOf(locators.password));
        locators.password.sendKeys(password);

        if (expectedResult) {
            wait.until(ExpectedConditions.elementToBeClickable(locators.inpatientWard));
            locators.inpatientWard.click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(locators.loginButton));
        locators.loginButton.click();

        if (!expectedResult) {
            Assert.assertTrue(locators.locationError.getText().contains("You must choose "));
        } else {
            Assert.assertTrue(locators.errorMessage.getText().contains("Please try again."));
        }

        if (!expectedResult) {
            driver.get(ConfigReader.getProperty("URL"));
        }
    }

    @DataProvider
    public Object[][] userData() {
        return new Object[][]{
                {"Ümmühan", "123457a", false},
                {"Merve", "12dd7a", false},
                {"Sefa", "1vvv57a", false},
                {"Kerim", "1xxx7a", false},
                {"Songül", "1abc7a", false},
                {"Egemen", "Admin12", true},
        };
    }
}