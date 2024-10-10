package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_406_408_POM extends BaseDriver {

    public US_406_408_POM(){
        PageFactory.initElements(BaseDriver.driver, this);}

    String surName="Hostert";
    String ID="100 HTR";

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "Registration Desk")
    public WebElement registrationDesk;

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(xpath = "//i[@class='icon-search']")
    public WebElement findPatientRecord;

    @FindBy(xpath = "//input[@id='patient-search']")
    public WebElement name;

    @FindBy(xpath = "//input[@class='form-control']")
    public WebElement surname;

    @FindBy(xpath ="//td[text()='No matching records found']")
    public WebElement text;


}
