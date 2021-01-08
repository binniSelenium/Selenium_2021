/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author jaym
 */
public class AnnMarieGshopping {
    
    public AnnMarieGshopping() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\QA\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Navigate to URL
        driver.get("https://annmariegianni.com");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
 
        
        
        
    @Test
    public void CreateAccount() {
        
        driver.findElement(By.id("menu-item-13432")).click();
        driver.findElement(By.name("customer[first_name]")).sendKeys("Miki");
        driver.findElement(By.name("customer[last_name]")).sendKeys("Patel");
        driver.findElements(By.name("customer[email]")).get(1).sendKeys("aaa94@gmail.com");
        driver.findElements(By.name("customer[password]")).get(1).sendKeys("mp123a456");
        driver.findElement(By.xpath("//*[@id=\"create_customer\"]/div[5]/input")).click();
        /*driver.findElement(By.id("first_name")).click();
        driver.findElement(By.id("first_name")).sendKeys("Bi");
        driver.findElement(By.id("last_name")).click();;
        driver.findElement(By.id("last_name")).sendKeys("Nni");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("dabc35097@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("20Jan21");
        driver.findElement(By.className("secondary button")).submit(); */
    }
        
    @Test
    public void testLoginAndLogout() {
                
        driver.findElement(By.id("menu-item-13432")).click();  //click My Account link
        driver.findElement(By.id("customer_email")).click();
        driver.findElement(By.id("customer_email")).sendKeys("aaa94@gmail.com");
        driver.findElement(By.id("customer_password")).click();
        driver.findElement(By.id("customer_password")).sendKeys("mp123a456");
        driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[3]/input")).click();  //Login button
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/nav/a")).click();  //Logout
    }
        
    @Test
    public void testShop() {
        
        driver.findElement(By.id("shop-now-home-hero")).click();
        //driver.findElement(By.cssSelector(".button.button button--secondary beauty-grid__hero__cta")).click();
        driver.findElement(By.cssSelector(".button.button--secondary.beauty-grid__hero__cta")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/section/div[2]/div[2]/a/img")).click();
        driver.findElement(By.className("increment")).click();
        driver.findElement(By.id("autodeliver_on_radio_1674198909002")).click();
        driver.findElements(By.className("product--subscription-btn")).get(2).click();
        driver.findElement(By.cssSelector(".add.clearfix.addtocart")).click();
        driver.findElement(By.cssSelector(".sidecart--btn.sidecart--continue_cart.visible")).click();
        driver.findElement(By.cssSelector(".button.add.checkout_button.carthook_checkout.elm_pos_0")).click();
    }
    
    @Test
    public void testSearchBox() throws InterruptedException {
        driver.findElement(By.id("searchform-3")).click();
        driver.findElement(By.id("searchform-3")).clear();
        driver.findElement(By.id("searchform-3")).sendKeys("cleansers"); //search for cleansers 
        driver.findElement(By.id("searchform-3")).submit();
        Thread.sleep(2000);
        driver.findElements(By.className("grid-image")).get(2).click();
        driver.findElement(By.name("button")).submit();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".sidecart--btn.sidecart--continue_cart.visible")).click(); //click REVIEW ORDER button
        driver.findElement(By.cssSelector(".button.add.checkout_button.carthook_checkout.elm_pos_0")).click();
        assertEquals("Information - Annmarie Skin Care - Checkout",driver.getTitle());
    }
    
    @Test
    public void testSampleDropdown() throws InterruptedException {
        driver.findElement(By.partialLinkText("SAMPLE")).click();
        driver.findElement(By.className("buynow")).click();
        driver.findElement(By.xpath("//*[@id=\"samplekitbtn\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/section[6]/div/div[3]/ul/li[3]/a")).click();  //full xpath of Oily Skin option
        Thread.sleep(2000);
        driver.findElement(By.id("osselectbtn")).click();  //Select button
        driver.findElement(By.xpath("//*[@id=\"cn-accept-cookie\"]/strong")).click();  //ACCEPT cookies
        Thread.sleep(3000);
        //driver.findElement(By.cssSelector(".selectbtn")).click(); // AddToCart button
        //driver.findElement(By.xpath("//*[@id=\"frmos\"]/p[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"frmos\"]/p[4]/a")).click();  //Miki
        
    }
    
}  //end of class AnnMarie
