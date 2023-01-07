package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".skip-account .label")
    private WebElement accountButton;
    @FindBy(css = "[title='Log In']")
    private WebElement loginLink;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(css = "[title='Log Out']")
    private WebElement logoutButton;

    @FindBy(css="[title='Register']")
    private WebElement registerLink;

    @FindBy(css = "#header-account ul :nth-child(2)")
    private  WebElement myWishListButton;

    public void clickAccountButton() {
        accountButton.click();
    }
    public void clickLoginLink() {
        loginLink.click();
    }
    public void setSearchField(String searchValue) {
        searchField.clear();
        searchField.sendKeys(searchValue + Keys.ENTER);
    }

    public void clickLogoutButton() {
        logoutButton.click();

    }

    public String getLoginText(){
        return loginLink.getText();
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

    public void clickMyWishListButton() {
        myWishListButton.click();
    }
}