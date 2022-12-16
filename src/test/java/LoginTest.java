import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private WebDriver driver;
    @Before
    public void initDriver(){

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
    @Test
    public void loginWithValidData() {

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement welcomeTextElement = driver.findElement(By.cssSelector("p.hello"));

        String expectedText = "Hello, Cosmin Fast!";
        String actualText = welcomeTextElement.getText();

        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void loginInvalidEmail(){

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@org");
        driver.findElement(By.id("email")).sendKeys(Keys.ENTER);

        String actualBorderValue = driver.findElement(By.cssSelector("li .input-box #email")).getCssValue("border-color");
        System.out.println(actualBorderValue);
        String expectedBorderValue = "rgb(223, 40, 10)";

        Assert.assertEquals( expectedBorderValue,actualBorderValue);

        WebElement ErrorMsg = driver.findElement(By.id("advice-validate-email-email"));
        String expectedErrorMsg = "Please enter a valid email address. For example johndoe@domain.com.";
        String actualErrorMsg = ErrorMsg.getText();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

    }
    @Test
    public void loginInvalidPassword(){

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456789");
        driver.findElement(By.id("send2")).click();

        WebElement ErrorMsg = driver.findElement(By.cssSelector(".error-msg span"));

        String actualErrorMsg = ErrorMsg.getText();
        String expectedErrorMsg = "Invalid login or password.";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

    }
    @Test
    public void tryLoginWithShortPassword(){

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("12");
        driver.findElement(By.id("send2")).click();

        WebElement ErrorMsg = driver.findElement(By.id("advice-validate-password-pass"));

        String actualErrorMsg = ErrorMsg.getText();
        String expectedErrorMsg = "Please enter 6 or more characters without leading or trailing spaces.";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

    }
    @After
    public void quit(){
        driver.close();
    }
}
