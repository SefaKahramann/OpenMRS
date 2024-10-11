package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_402_405_406_POM{

    public US_402_405_406_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css = "[class='gt-current-lang']")
    public WebElement languageButton;

    @FindBy(css = "[data-gt-lang='en']")
    public WebElement selectEnglish;

    @FindBy(partialLinkText = "Demo")
    public WebElement demoButton;

    @FindBy(xpath = "(//span[@class='elementor-button-text'])[2]")
    public WebElement exploreOpenMRS2;

    @FindBy(xpath = "(//div[@class='elementor-button-wrapper'])[4]/a")
    public WebElement enterOpenMRSDemo;

    @FindBy(xpath = "//form[@id='login-form']//legend")
    public WebElement loginText;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "Inpatient Ward")
    public WebElement inpatientWard;

    @FindBy(css = "ul[id='sessionLocation'] li")
    public List<WebElement> lacationList;

    @FindBy(id = "loginButton")
    public WebElement logInButton;

    @FindBy(id = "error-message")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@id='content']//h4")
    public WebElement loginControl;

    @FindBy(linkText = "My Account")
    public WebElement myAccountLink;

    @FindBy(css = "li[class='nav-item identifier']")
    public WebElement adminFunc;

    @FindBy(linkText = "Change Password")
    public WebElement changePasswordButton;

    @FindBy(xpath = "//div[@id='content']//h2")
    public WebElement changePassContText;

    @FindBy(linkText = "My Languages")
    public WebElement myLanguageButton;

    @FindBy(xpath = "//div[@id='content']//h2")
    public WebElement myLanguageText;

    @FindBy(linkText = "Find Patient Record")
    public WebElement patientRecordButton;

    @FindBy(xpath = "//div[@id='content']//h2")
    public WebElement findPatientRecord;

    @FindBy(id = "patient-search")
    public WebElement searchBox;

    @FindBy(xpath = "//*[.='No matching records found']")
    public WebElement  noPatientsFound;
}
