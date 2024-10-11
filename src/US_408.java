import Pages.US_403_408_409_410_POM;
import Utility.BaseDriver;
import Utility.ConfigReader;
import Utility.MyFunc;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class US_408 extends BaseDriver {

    @Test(groups = "Regression Test")
    public void patientList() {
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

        wait.until(ExpectedConditions.elementToBeClickable(element.findPatient));
        element.findPatient.click();

        List<String> patientsId = new ArrayList<>();
        boolean isNextPageAvailable = true;
        do {
            for (WebElement ids : element.IDs) {
                String patientsIdStr = (ids.getText());
                if (!patientsId.contains(patientsIdStr)) {
                    patientsId.add(patientsIdStr);
                } else {
                    isNextPageAvailable = false;
                }
            }

            try {
                if (element.nextBtn.isEnabled()) {
                    wait.until(ExpectedConditions.elementToBeClickable(element.nextBtn));
                    MyFunc.jsClick(element.nextBtn);
                    wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("findPatientURL")));
                } else {
                    isNextPageAvailable = false;
                }
            } catch (Exception e) {
                isNextPageAvailable = false;
            }
        } while (isNextPageAvailable);

        String patientsIdsStr = String.valueOf(patientsId.size());
        wait.until(ExpectedConditions.visibilityOf(element.searchResultTable));
        Assert.assertTrue(element.searchResultTable.getText().contains(patientsIdsStr));
    }
}
