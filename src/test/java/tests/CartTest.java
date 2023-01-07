package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.HomePage;
import pages.WishListPage;

public class CartTest {

    private WebDriver driver;
    private WishListPage wishListPage;

    private HomePage homePage;

    private CartPage cartPage;
    @Before
    public void initDriver() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        wishListPage = new WishListPage(driver);
        cartPage = new CartPage(driver);
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void addProductToCart(){

        wishListPage.clickSaleButton();
        wishListPage.clickFirstProductButton();
        cartPage.clickColorProductButton();
        cartPage.clickSizeProductButton();
        cartPage.clickAddToCartButton();

        String expectedText = "Slim fit Dobby Oxford Shirt was added to your shopping cart.";
        String actualText = cartPage.getSuccessfulAddedToCartMsg();
        Assert.assertEquals(actualText, expectedText);
    }

//    @After
//    public void quit(){
//
//        driver.close();
//    }
}
