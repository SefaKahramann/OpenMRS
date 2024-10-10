import Pages.US_401_404_407_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class US_404 extends BaseDriver {
    public String patientID;

    @Test(groups = "Regression Test",dependsOnMethods = "US_402")
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

        wait.until(ExpectedConditions.elementToBeClickable(locator.address));
        locator.address.sendKeys(ConfigReader.getProperty("address"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.city));
        locator.city.sendKeys(ConfigReader.getProperty("city"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.state));
        locator.state.sendKeys(ConfigReader.getProperty("state"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.country));
        locator.country.sendKeys(ConfigReader.getProperty("country"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.postalCode));
        locator.postalCode.sendKeys(ConfigReader.getProperty("postalCode"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.nextButton));
        locator.nextButton.click();

        long random = ThreadLocalRandom.current().nextLong(10000000000L, 100000000000L);
        String phoneNumber = String.valueOf(random);
        wait.until(ExpectedConditions.elementToBeClickable(locator.phoneNumber));
        locator.phoneNumber.sendKeys(phoneNumber);

        wait.until(ExpectedConditions.elementToBeClickable(locator.nextButton));
        locator.nextButton.click();

        Select relationship = new Select(locator.selectRelatives);
        relationship.selectByIndex((int) (Math.random() * 9));

        wait.until(ExpectedConditions.elementToBeClickable(locator.personName));
        locator.personName.sendKeys(ConfigReader.getProperty("personName"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.nextButton));
        locator.nextButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(locator.confirmButton));
        locator.confirmButton.click();

        wait.until(ExpectedConditions.visibilityOf(locator.givenControl));
        Assert.assertTrue(locator.givenControl.isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(locator.familyNameControl));
        Assert.assertTrue(locator.familyNameControl.isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(locator.IDcontrol));
        patientID = locator.IDcontrol.getText();
        Assert.assertTrue(locator.IDcontrol.isDisplayed());
    }
}
