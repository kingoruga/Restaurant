
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
public class menuViewTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
        // Start browser
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:39293/Restaurants/index.htm");
        WebElement viewMenuLink = driver.findElement(By.linkText("View Menu"));
        viewMenuLink.click();
        String strURL = driver.getCurrentUrl();
        System.out.println("Current URL: - " + strURL);
    }
}
