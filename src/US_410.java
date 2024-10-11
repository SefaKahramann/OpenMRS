import Pages.US_403_408_409_410_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_410 extends BaseDriver {

    @Test(groups = "Regression Test")
    public void wrongTimeZone() {
        US_403_408_409_410_POM element = new US_403_408_409_410_POM();

        driver.get(ConfigReader.getProperty("loginURL"));

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

        wait.until(ExpectedConditions.visibilityOf(element.findPatient));
        element.findPatient.click();

        int randomPatientIds = (int) (Math.random() * element.IDs.size());
        String patientIds = element.IDs.get(randomPatientIds).getText().replace("Recent", "").trim();

        wait.until(ExpectedConditions.elementToBeClickable(element.pageBackHome));
        element.pageBackHome.click();

        wait.until(ExpectedConditions.elementToBeClickable(element.appointmentSchedulingBtn));
        element.appointmentSchedulingBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(element.manageAppointmentsBtn));
        element.manageAppointmentsBtn.click();

        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("manageAppointmentsURL")));
        element.searchById.sendKeys(patientIds);

        wait.until(ExpectedConditions.visibilityOf(element.patientSearchResult));
        element.patientSearchResult.click();

        wait.until(ExpectedConditions.visibilityOf(element.timeZoneWarning));
        Assert.assertTrue(element.timeZoneWarning.getText().contains("Your computer is not set to the right time zone"));
    }
}
