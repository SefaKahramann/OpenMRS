import Pages.US_402_405_406_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_406 extends BaseDriver {
    @Test(groups = "Regression Test")
    public void patientSearchInPatientListNegative() {
        US_402_405_406_POM element = new US_402_405_406_POM();

        driver.get(ConfigReader.getProperty("loginURL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("loginURL")));

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

        wait.until(ExpectedConditions.elementToBeClickable(element.patientRecordButton));
        element.patientRecordButton.click();
        Assert.assertTrue(element.findPatientRecord.getText().contains("Patient Record"));

        wait.until(ExpectedConditions.elementToBeClickable(element.searchBox));
        element.searchBox.sendKeys(ConfigReader.getProperty("samplePatientName") + Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOf(element.noPatientsFound));
        Assert.assertTrue(element.noPatientsFound.getText().contains("No matching"));
    }
}