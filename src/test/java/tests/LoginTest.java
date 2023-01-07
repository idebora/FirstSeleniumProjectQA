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



public class LoginTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Before
    public void initDriver() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void loginWithValidData() {

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("cosmin@fasttrackit.org");
        loginPage.setPasswordField("123456");
        loginPage.clickLoginButton();

        String expectedText = "Hello, Cosmin Fast!";
        String actualText = accountPage.getWelcomeText();
        Assert.assertEquals(actualText, expectedText);
        //        if (actualText.equals(expectedText)) {
        //            System.out.println("S-a logat cu success!");
        //        } else
        //            System.err.println("Nu s-a logat. ");
    }

    @Test
    public void loginInvalidEmail() {

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("cosmin@org");
        loginPage.setPasswordField("123456");
        loginPage.clickLoginButton();

        String actualBorderValue = loginPage.getEmailFieldBorder();
        String expectedBorderValue = "rgb(223, 40, 10)";

        Assert.assertEquals(expectedBorderValue, actualBorderValue);

        String expectedErrorMsg = "Please enter a valid email address. For example johndoe@domain.com.";
        String actualErrorMsg = loginPage.getValidEmailMsg();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

    }

    @Test
    public void loginInvalidPassword() {

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("cosmin@fasttrackit.org");
        loginPage.setPasswordField("123456999j");
        loginPage.clickLoginButton();

        String actualErrorMsg = loginPage.getInvalidMsg();
        String expectedErrorMsg = "Invalid login or password.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

    }

    @Test
    public void tryLoginWithShortPassword() {

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("cosmin@fasttrackit.org");
        loginPage.setPasswordField("12");
        loginPage.clickLoginButton();

        String actualErrorMsg = loginPage.getShortPassMsg();
        String expectedErrorMsg = "Please enter 6 or more characters without leading or trailing spaces.";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

    }

    @Test
    public void logOut() {

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("cosmin@fasttrackit.org");
        loginPage.setPasswordField("123456");
        loginPage.clickLoginButton();
        homePage.clickAccountButton();
        homePage.clickLogoutButton();
        homePage.clickAccountButton();

        String actualText = homePage.getLoginText();
        String expectedText = "Log In";

        Assert.assertEquals(actualText, expectedText);

    }
//    @After
//    public void quit(){
//        driver.close();
//    }
}
