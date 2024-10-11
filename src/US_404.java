import Pages.US_401_404_407_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_404 extends BaseDriver {
    public String patientID;

    @Test(groups = "Regression Test")
    public void patientRegistration() {
        US_401_404_407_POM locator = new US_401_404_407_POM();

        driver.get(ConfigReader.getProperty("loginURL"));

        wait.until(ExpectedConditions.visibilityOf(locator.userName));
        locator.userName.sendKeys(ConfigReader.getProperty("username"));

        wait.until(ExpectedConditions.visibilityOf(locator.password));
        locator.password.sendKeys(ConfigReader.getProperty("password"));

        int randomLocation = (int) (Math.random() * locator.locations.size());
        String selectLocation = locator.locations.get(randomLocation).getText();

        wait.until(ExpectedConditions.elementToBeClickable(locator.locations.get(randomLocation)));
        locator.locations.get(randomLocation).click();

        wait.until(ExpectedConditions.elementToBeClickable(locator.loginButton));
        locator.loginButton.click();
        Assert.assertTrue(locator.loginControl.getText().contains(selectLocation));

        wait.until(ExpectedConditions.elementToBeClickable(locator.registerButton));
        locator.registerButton.click();
        Assert.assertTrue(locator.nextButton.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(locator.givenButton));
        locator.givenButton.sendKeys(ConfigReader.getProperty("given"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.middleButton));
        locator.middleButton.sendKeys(ConfigReader.getProperty("middle"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.familyNameButton));
        locator.familyNameButton.sendKeys(ConfigReader.getProperty("familyName"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.nextButton));
        locator.nextButton.click();

        Select gender = new Select(locator.selectMenu);
        gender.selectByValue("F");

        wait.until(ExpectedConditions.elementToBeClickable(locator.nextButton));
        locator.nextButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(locator.birthdateDay));
        locator.birthdateDay.sendKeys(ConfigReader.getProperty("birthday"));

        Select month = new Select(locator.birtdateMonth);
        wait.until(ExpectedConditions.elementToBeClickable(locator.birtdateMonth));
        month.selectByIndex((int) (Math.random() * 11));

        wait.until(ExpectedConditions.elementToBeClickable(locator.birtdateYear));
        locator.birtdateYear.sendKeys(ConfigReader.getProperty("birthYear"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.nextButton));
        locator.nextButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(locator.confirmButton));
        locator.confirmButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(locator.findPatientButton));
        locator.findPatientButton.click();

        wait.until(ExpectedConditions.visibilityOf(locator.findPatientPageControl));
        Assert.assertTrue(locator.findPatientPageControl.getText().contains("Find Patient"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.searchBox));
        locator.searchBox.sendKeys(ConfigReader.getProperty("usernameSecond"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.patientInformation));
        locator.patientInformation.click();

        wait.until(ExpectedConditions.visibilityOf(locator.givenControl));
        Assert.assertTrue(locator.givenControl.isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(locator.familyNameControl));
        Assert.assertTrue(locator.familyNameControl.isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(locator.IDcontrol));
        patientID = locator.IDcontrol.getText();
        Assert.assertTrue(locator.IDcontrol.isDisplayed());
    }
}
