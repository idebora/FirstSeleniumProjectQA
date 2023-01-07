package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
    private WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li.nav-5 a.level0.has-children")
    private WebElement saleButton;

    @FindBy(id = "product-collection-image-403")
    private WebElement firstProductButton;

    @FindBy(css = ".add-to-links a.link-wishlist")
    private WebElement addWishListButton;

    @FindBy(css = ".my-wishlist .success-msg span")
    private WebElement successAddWishListMsg;

    @FindBy(css = ".customer-wishlist-item-remove a")
    private WebElement removeWishListButton;

    @FindBy(css = ".cart-cell [title='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy(css = ".notice-msg span")
    private WebElement noticeAddMsg;


    public void clickSaleButton() {
        saleButton.click();
    }

    public void clickFirstProductButton() {
        firstProductButton.click();
    }

    public void clickaddWishListButton() {
        addWishListButton.click();
    }

    public String getSuccessfulAddToWishListMsg(){
        return successAddWishListMsg.getText();
    }

    public void clickRemoveWishListButton() {
        removeWishListButton.click();
    }

    public void clickaddToCartButton() {
        addToCartButton.click();
    }

    public String getNoticeAddMsg() {
        return noticeAddMsg.getText();
    }
}
