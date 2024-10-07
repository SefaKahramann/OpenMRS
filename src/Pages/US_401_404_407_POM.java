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

    @FindBy(id = "Inpatient Ward")
    public WebElement inpatientWard;

    @FindBy(xpath = "//div[@id='content']//h4")
    public WebElement loginControl;

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

    @FindBy(id = "address1")
    public WebElement address;

    @FindBy(id = "cityVillage")
    public WebElement city;

    @FindBy(id = "stateProvince")
    public WebElement state;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "postalCode")
    public WebElement postalCode;

    @FindBy(name = "phoneNumber")
    public WebElement phoneNumber;

    @FindBy(id = "relationship_type")
    public WebElement selectRelatives;

    @FindBy(css = "[placeholder='Person Name'] ")
    public WebElement personName;

    @FindBy(id = "submit")
    public WebElement confirmButton;

    @FindBy(css = "[class='PersonName-givenName']")
    public WebElement givenControl;

    @FindBy(css = "[class='PersonName-familyName']")
    public WebElement familyNameControl;

    @FindBy(css = "[class='float-sm-right']")
    public WebElement IDcontrol;
}
