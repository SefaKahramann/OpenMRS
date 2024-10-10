import Pages.US_406_408_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_406 extends BaseDriver {

    @Test(groups = "PatientManagement")
    public void patientSearchingPatientList() {
        US_406_408_POM elements = new US_406_408_POM();

        driver.get(ConfigReader.getProperty("loginURL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("loginURL")));

        wait.until(ExpectedConditions.elementToBeClickable(elements.username));
        elements.username.sendKeys(ConfigReader.getProperty("username"));

        wait.until(ExpectedConditions.elementToBeClickable(elements.password));
        elements.password.sendKeys(ConfigReader.getProperty("password"));

        wait.until(ExpectedConditions.elementToBeClickable(elements.registrationDesk));
        elements.registrationDesk.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.loginButton));
        elements.loginButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.findPatientRecord));
        elements.findPatientRecord.click();

        wait.until(ExpectedConditions.visibilityOf(elements.name));
        elements.name.sendKeys(ConfigReader.getProperty("name"));

        wait.until(ExpectedConditions.visibilityOf(elements.text));
        Assert.assertTrue(elements.text.getText().contains("No matching records found"));
    }
}
