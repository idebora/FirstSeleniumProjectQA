package pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstname")
    private WebElement firstnameField;

    @FindBy(id = "middlename")
    private WebElement middlenameField;


    @FindBy(id = "lastname")
    private WebElement lastnameField;

    @FindBy(id="email_address")
    private WebElement emailField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(id="confirmation")
    private WebElement confirmationField;

    @FindBy(id = "is_subscribed")
    private WebElement subscribeButton;

    @FindBy(css = "[title='Register'] span span")
    private WebElement registerButton;

    @FindBy(css = "li.success-msg span")
    private WebElement successfulRegisterMsg;

    @FindBy(css = "li.error-msg span")
    private WebElement errorRegisterMsg;

    @FindBy(css = "div#advice-validate-email-email_address.validation-advice")
    private WebElement errorEmailMsg;

    public void setFirstnameField(String s) {
        firstnameField.sendKeys(s);
    }

    public void setMiddlenameField(String s) {
        middlenameField.sendKeys(s);
    }

    public void setLastnameField(String s) {
        lastnameField.sendKeys(s);
    }

    public void setEmailField(String s) {
        emailField.sendKeys(s + Keys.ENTER);

    }
    public void setPasswordField(String s) {
        passwordField.sendKeys(s);
    }

    public void setConfirmationField(String s) {
        confirmationField.sendKeys(s);
    }
    public void clickSubscribeButton() {
        subscribeButton.click();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public String getSuccessfulRegisterMsg(){
        return successfulRegisterMsg.getText();
    }

    public String getErrorRegisterMsg(){
        return errorRegisterMsg.getText();
    }
    public String getEmailFieldBorder(){
        return emailField.getCssValue("border-color");
    }

    public String getErrorEmailMsg(){
        return errorEmailMsg.getText();
    }
}
