import Pages.US_401_404_407_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_407 extends BaseDriver {

    @Test(groups = "Smoke Test")
    public void patientDeletion() {
        US_401_404_407_POM locator = new US_401_404_407_POM();

        driver.get(ConfigReader.getProperty("loginURL"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.userName));
        locator.userName.sendKeys(ConfigReader.getProperty("username"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.password));
        locator.password.sendKeys(ConfigReader.getProperty("password"));

        int randomLocations = (int) (Math.random() * locator.locations.size());
        String location = locator.locations.get(randomLocations).getText();

        wait.until(ExpectedConditions.elementToBeClickable(locator.locations.get(randomLocations)));
        locator.locations.get(randomLocations).click();

        wait.until(ExpectedConditions.elementToBeClickable(locator.loginButton));
        locator.loginButton.click();

        wait.until(ExpectedConditions.visibilityOf(locator.loginControl));
        Assert.assertTrue(locator.loginControl.getText().contains(location));

        wait.until(ExpectedConditions.visibilityOf(locator.adminControl));
        Assert.assertTrue(locator.adminControl.getText().contains("admin"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.findPatientButton));
        locator.findPatientButton.click();

        wait.until(ExpectedConditions.visibilityOf(locator.findPatientPageControl));
        Assert.assertTrue(locator.findPatientPageControl.getText().contains("Find Patient"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.searchBox));
        locator.searchBox.sendKeys(ConfigReader.getProperty("usernameSecond"));

        wait.until(ExpectedConditions.visibilityOf(locator.patientInformation));
        locator.patientInformation.click();

        wait.until(ExpectedConditions.visibilityOf(locator.givenControl));
        Assert.assertTrue(locator.givenControl.isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(locator.familyNameControl));
        Assert.assertTrue(locator.familyNameControl.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(locator.deletePatient));
        locator.deletePatient.click();

        wait.until(ExpectedConditions.visibilityOf(locator.deleteWindowControl));
        Assert.assertTrue(locator.deleteWindowControl.getText().contains("Delete Patient"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.reasonBox));
        locator.reasonBox.sendKeys(ConfigReader.getProperty("sampleReason"));

        wait.until(ExpectedConditions.elementToBeClickable(locator.buttonConfirm));
        locator.buttonConfirm.click();

        wait.until(ExpectedConditions.elementToBeClickable(locator.searchBox));
        locator.searchBox.sendKeys(ConfigReader.getProperty("usernameSecond"));

        wait.until(ExpectedConditions.visibilityOf(locator.noPatientsFound));
        Assert.assertTrue(locator.noPatientsFound.getText().contains("No matching"));
    }
}
