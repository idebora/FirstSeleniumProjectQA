package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "option27")
    private WebElement colorProductButton;

    @FindBy(id = "option81")
    private WebElement sizeProductButton;

    @FindBy(css = ".add-to-cart-buttons [title='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy(css = ".cart .success-msg span")
    private WebElement successAddedToCartMsg;

    public void clickColorProductButton(){
        colorProductButton.click();
    }

    public void clickSizeProductButton(){
        sizeProductButton.click();
    }
    public void clickAddToCartButton(){
        addToCartButton.click();
    }
    public String getSuccessfulAddedToCartMsg(){
        return successAddedToCartMsg.getText();
    }
}
