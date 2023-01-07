package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".error-msg span")
    private WebElement invalidPassErr;

    @FindBy(id = "advice-validate-password-pass")
    private WebElement shortPassErr;
    @FindBy(id = "advice-validate-email-email")
    private WebElement validEmailErr;

    @FindBy(id = "send2")
    private WebElement loginButton;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    public String getInvalidMsg(){
        return invalidPassErr.getText();
    }
    public String getShortPassMsg(){
        return shortPassErr.getText();
    }
    public String getValidEmailMsg(){
        return validEmailErr.getText();
    }

    public void setEmailField(String s) {
        emailField.sendKeys(s);
    }

    public void setPasswordField(String s) {
        passwordField.sendKeys(s);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getEmailFieldBorder(){
        return emailField.getCssValue("border-color");
    }
}
