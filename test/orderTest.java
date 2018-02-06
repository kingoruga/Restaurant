
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author syntel
 */
public class orderTest {

    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
        // Start browser
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("http://localhost:39293/Restaurants/login.htm");
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        email.sendKeys("dbay@ymail.com");
        password.sendKeys("2Gj");
        System.out.println("Text Field Set");
        WebElement login = driver.findElement(By.className("btn btn-primary"));
        login.click();
        String strURL = driver.getCurrentUrl();
        System.out.println("Current URL: - " + strURL);

    }
}
