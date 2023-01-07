package tests;

import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.RegisterPage;


public class RegisterTest {

    private WebDriver driver;

    private HomePage homePage;

    private RegisterPage registerPage;
    @Before
    public void initDriver(){

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
    @Test
    public void registerWithValidData() {

        homePage.clickAccountButton();
        homePage.clickRegisterLink();
        registerPage.setFirstnameField("Elisa");
        registerPage.setMiddlenameField("lizzy");
        registerPage.setLastnameField("Duma");
        registerPage.setEmailField("kegeti6394@dentaltz.com");
        registerPage.setPasswordField("123456");
        registerPage.setConfirmationField("123456");
        registerPage.clickSubscribeButton();
        registerPage.clickRegisterButton();

        String expectedText = "Thank you for registering with Madison Island.";
        String actualText = registerPage.getSuccessfulRegisterMsg();

        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void tryToRegisterWithTheSameEmail(){

        homePage.clickAccountButton();
        homePage.clickRegisterLink();
        registerPage.setFirstnameField("Elisa");
        registerPage.setMiddlenameField("lizzy");
        registerPage.setLastnameField("Duma");
        registerPage.setEmailField("kegeti6394@dentaltz.com");
        registerPage.setPasswordField("123456");
        registerPage.setConfirmationField("123456");
        registerPage.clickSubscribeButton();
        registerPage.clickRegisterButton();


//        WebElement successMsj = driver.findElement(By.cssSelector("li.error-msg span"));
        String expectedText = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
        String actualText = registerPage.getErrorRegisterMsg();

        Assert.assertEquals(actualText, expectedText);

    }
    @Test
    public void registerWithInvalidEmail(){

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Elisa");
        driver.findElement(By.id("middlename")).sendKeys("Lizzy");
        driver.findElement(By.id("lastname")).sendKeys("Duma");
        driver.findElement(By.id("email_address")).sendKeys("xicuqu@br");
        driver.findElement(By.id("email_address")).sendKeys(Keys.ENTER);

        String actualBorderValue = driver.findElement(By.cssSelector("div.input-box #email_address")).getCssValue("border-color");
        System.out.println(actualBorderValue);
        String expectedBorderValue = "rgb(223, 40, 10)";

        Assert.assertEquals( expectedBorderValue,actualBorderValue);

        WebElement ErrorMsg = driver.findElement(By.cssSelector("div#advice-validate-email-email_address.validation-advice"));
        String expectedErrorMsg = "Please enter a valid email address. For example johndoe@domain.com.";
        String actualErrorMsg = ErrorMsg.getText();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

//    @After
//    public void quit(){
//
//        driver.close();
//    }
}
