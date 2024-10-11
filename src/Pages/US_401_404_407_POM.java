package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_401_404_407_POM {

    public US_401_404_407_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css = "[class='gt-current-lang']")
    public WebElement languageButton;

    @FindBy(css = "[data-gt-lang='en']")
    public WebElement languageEnglish;

    @FindBy(partialLinkText = "Demo")
    public WebElement demoButton;

    @FindBy(xpath = "(//span[@class='elementor-button-text'])[2]")
    public WebElement exploreOpenMrs2;

    @FindBy(xpath = "(//div[@class='elementor-button-wrapper'])[4]/a")
    public WebElement enterOpenMrs2;

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(id = "error-message")
    public WebElement errorMessage;

    @FindBy(id = "sessionLocationError")
    public WebElement locationError;

    @FindBy(css = "[id='apps'] a")
    public WebElement findPatientButton;

    @FindBy(css = "[id='content'] h2")
    public WebElement findPatientPageControl;

    @FindBy(id = "Inpatient Ward")
    public WebElement inpatientWard;

    @FindBy(xpath = "//div[@id='content']//h4")
    public WebElement loginControl;

    @FindBy(css = "[id='navbarSupportedContent'] ul li")
    public WebElement adminControl;

    @FindBy(css = "[id='sessionLocation'] li")
    public List<WebElement> locations;

    @FindBy(css = "[class='icon-user']")
    public WebElement registerButton;

    @FindBy(name = "givenName")
    public WebElement givenButton;

    @FindBy(name = "middleName")
    public WebElement middleButton;

    @FindBy(name = "familyName")
    public WebElement familyNameButton;

    @FindBy(id = "next-button")
    public WebElement nextButton;

    @FindBy(id = "gender-field")
    public WebElement selectMenu;

    @FindBy(name = "birthdateDay")
    public WebElement birthdateDay;

    @FindBy(name = "birthdateMonth")
    public WebElement birtdateMonth;

    @FindBy(name = "birthdateYear")
    public WebElement birtdateYear;

    @FindBy(id = "submit")
    public WebElement confirmButton;

    @FindBy(css = "[class='PersonName-givenName']")
    public WebElement givenControl;

    @FindBy(css = "[class='PersonName-familyName']")
    public WebElement familyNameControl;

    @FindBy(css = "[class='float-sm-right']")
    public WebElement IDcontrol;

    @FindBy(id = "patient-search")
    public WebElement searchBox;

    @FindBy(xpath = "(//tr[@class='odd']//td)[1]")
    public WebElement patientInformation;

    @FindBy(id = "org.openmrs.module.coreapps.deletePatient")
    public WebElement deletePatient;

    @FindBy(css = "[id='delete-patient-creation-dialog'] h3")
    public WebElement deleteWindowControl;

    @FindBy(id = "delete-reason")
    public WebElement reasonBox;

    @FindBy(xpath = "//div[@tabindex='-1']//button")
    public WebElement  buttonConfirm;

    @FindBy(css = "[class='dataTables_empty']")
    public WebElement  noPatientsFound;
}
