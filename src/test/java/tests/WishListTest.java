package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.WishListPage;

public class WishListTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private WishListPage wishListPage;
    @Before
   public void initDriver(){
       System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
       driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        wishListPage = new WishListPage(driver);
       driver.manage().window().maximize();
       driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addToWishlistTest(){

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("cosmin@fasttrackit.org");
        loginPage.setPasswordField("123456");
        loginPage.clickLoginButton();
        wishListPage.clickSaleButton();
        wishListPage.clickFirstProductButton();
        wishListPage.clickaddWishListButton();


        WebElement successMsg = driver.findElement(By.cssSelector(".my-wishlist .success-msg span"));
        String expectedText = "Slim fit Dobby Oxford Shirt has been added to your wishlist. Click here to continue shopping.";
        String actualText = wishListPage.getSuccessfulAddToWishListMsg();

        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void removeProductFromWishList(){

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("cosmin@fasttrackit.org");
        loginPage.setPasswordField("123456");
        loginPage.clickLoginButton();
        wishListPage.clickSaleButton();
        wishListPage.clickFirstProductButton();
        wishListPage.clickaddWishListButton();
        homePage.clickAccountButton();
        homePage.clickMyWishListButton();
        wishListPage.clickRemoveWishListButton();
    }
    @Test
    public void addToCartFromWishList(){

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("cosmin@fasttrackit.org");
        loginPage.setPasswordField("123456");
        loginPage.clickLoginButton();
        wishListPage.clickSaleButton();
        wishListPage.clickFirstProductButton();
        wishListPage.clickaddWishListButton();
        wishListPage.clickaddToCartButton();



        String expectedText ="Please specify the product's option(s).";
        String actualText = wishListPage.getNoticeAddMsg();

        Assert.assertEquals(actualText, expectedText);
    }
    @After
    public void quit(){
        driver.close();
    }
}
