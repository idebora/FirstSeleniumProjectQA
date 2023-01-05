package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cart {

    private WebDriver driver;

    @Before
    public void initDriver() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void addProductToCart(){

        driver.findElement(By.cssSelector("li.nav-5 a.level0.has-children")).click();
        driver.findElement(By.id("product-collection-image-403")).click();
        driver.findElement(By.id("option27")).click();
        driver.findElement(By.id("option81")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons [title='Add to tests.Cart']")).click();

        WebElement successMsg = driver.findElement(By.cssSelector(".cart .success-msg span"));
        String expectedText = "Slim fit Dobby Oxford Shirt was added to your shopping cart.";
        String actualText = successMsg.getText();

        Assert.assertEquals(actualText, expectedText);
    }

    @After
    public void quit(){
        driver.close();
    }
}
