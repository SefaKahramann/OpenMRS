import Pages.US_403_408_409_410_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_409 extends BaseDriver {

    @Test(groups = "Regression Test")
    public void patientMerge() {
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

        wait.until(ExpectedConditions.elementToBeClickable(element.dataManagementBtn));
        element.dataManagementBtn.click();

        wait.until(ExpectedConditions.visibilityOf(element.mergePatientBtn));
        element.mergePatientBtn.click();

        wait.until(ExpectedConditions.visibilityOf(element.searchByName));
        element.searchByName.sendKeys(ConfigReader.getProperty("given"));

        wait.until(ExpectedConditions.visibilityOf(element.patientSearchResultTable));
        WebElement[] IDs = {element.patientId1, element.patientId2};
        for (int i = 0; i < element.IDs.size(); i++) {
            wait.until(ExpectedConditions.visibilityOf(element.IDs.get(i)));
            IDs[i].sendKeys(element.IDs.get(i).getText());
            if (i == 1) {
                IDs[i].sendKeys(Keys.ENTER);
            }
        }

        wait.until(ExpectedConditions.elementToBeClickable(element.yesContinueBtn));
        element.yesContinueBtn.click();

        wait.until(ExpectedConditions.visibilityOf(element.firstPatient));
        element.firstPatient.click();

        wait.until(ExpectedConditions.visibilityOf(element.mergePatientControlMessage));
        Assert.assertTrue(element.mergePatientControlMessage.getText().contains("Merging cannot be undone!"));

        wait.until(ExpectedConditions.elementToBeClickable(element.yesContinueBtn));
        element.yesContinueBtn.click();

        int randomIDsControl = (int) (Math.random() * element.IDsControl.size());
        String randomIdsControlStr = element.IDsControl.get(randomIDsControl).getText();

        wait.until(ExpectedConditions.visibilityOf(element.IDsControl.get(randomIDsControl)));
        Assert.assertTrue(element.IDsControl.get(randomIDsControl).getText().contains(randomIdsControlStr));
    }
}
