package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_403_408_409_410_POM {

    public US_403_408_409_410_POM() {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(css = "[class='gt-current-lang']")
    public WebElement languageBtn;

    @FindBy(css = "[data-gt-lang='en']")
    public WebElement languageEn;

    @FindBy(partialLinkText = "Demo")
    public WebElement demoBtn;

    @FindBy(xpath = "(//div[@class='elementor-button-wrapper'])[4]/a")
    public WebElement OpenMRS2DemoBtn;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//ul[@id='sessionLocation']/li")
    public List<WebElement> locations;

    @FindBy(id = "loginButton")
    public WebElement logInBtn;

    @FindBy(css = "[id='content'] h4")
    public WebElement logInControl;

    @FindBy(css = "[class='nav-item logout']>a")
    public WebElement logOutBtn;

    @FindBy(xpath = "(//div[@id='content']//a)[7]")
    public WebElement appointmentSchedulingBtn;

    @FindBy(xpath = "(//div[@id='apps']//a)[3]")
    public WebElement manageAppointmentsBtn;

    @FindBy(id = "patient-search")
    public WebElement searchById;

    @FindBy(css = "[class='odd']")
    public WebElement patientSearchResult;

    @FindBy(id = "time-zone-warning")
    public WebElement timeZoneWarning;

    @FindBy(xpath = "(//div[@id='content']//a)[9]")
    public WebElement dataManagementBtn;

    @FindBy(xpath = "//div[@id='tasks']//a")
    public WebElement mergePatientBtn;

    @FindBy(id = "patient-search")
    public WebElement searchByName;

    @FindBy(id = "patient-search-results")
    public WebElement patientSearchResultTable;

    @FindBy(xpath = "//tbody[@role='alert']//td[starts-with(text(),'100')]")
    public List<WebElement> IDs;

    @FindBy(id = "patient1-text")
    public WebElement patientId1;

    @FindBy(id = "patient2-text")
    public WebElement patientId2;

    @FindBy(id = "first-patient")
    public WebElement firstPatient;

    @FindBy(xpath = "//div[@class='messages-container']/h1")
    public WebElement mergePatientControlMessage;

    @FindBy(id = "confirm-button")
    public WebElement yesContinueBtn;

    @FindBy(xpath = "//div[@class='float-sm-right']/span")
    public List<WebElement> IDsControl;

    @FindBy(xpath = "(//div[@id='content']//a)[1]")
    public WebElement findPatient;

    @FindBy(linkText = "Next")
    public WebElement nextBtn;

    @FindBy(css = "i[class='icon-home small']")
    public WebElement pageBackHome;

    @FindBy(id = "patient-search-results-table_info")
    public WebElement searchResultTable;

}
