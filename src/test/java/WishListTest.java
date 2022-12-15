import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {

    private WebDriver driver;
    @Before
   public void initDriver(){
       System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void addToWishlistTest(){

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector("li.nav-5 a.level0.has-children")).click();
        driver.findElement(By.id("product-collection-image-403")).click();
        driver.findElement(By.cssSelector(".add-to-links a.link-wishlist")).click();


        WebElement successMsg = driver.findElement(By.cssSelector(".my-wishlist .success-msg span"));

        String expectedText = "Slim fit Dobby Oxford Shirt has been added to your wishlist. Click here to continue shopping.";

        String actualText = successMsg.getText();
        Assert.assertEquals(actualText, expectedText);
    }
@Test
    public void removeProductFromWishList(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("#header-account ul :nth-child(2)")).click();
        driver.findElement(By.cssSelector(".customer-wishlist-item-remove a")).click();

    }
    @Test
    public void addToCartFromWishList(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector("li.nav-5 a.level0.has-children")).click();
        driver.findElement(By.id("product-collection-image-403")).click();
        driver.findElement(By.cssSelector(".add-to-links a.link-wishlist")).click();
        driver.findElement(By.cssSelector(".cart-cell [title='Add to Cart']")).click();

        WebElement addMsg = driver.findElement(By.cssSelector(".notice-msg span"));

        String expectedText ="Please specify the product's option(s).";
        String actualText = addMsg.getText();

        Assert.assertEquals(actualText, expectedText);



    }
//    @After
//    public void quit(){
//        driver.close();
//    }
}
