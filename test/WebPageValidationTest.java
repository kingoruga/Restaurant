/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author syntel
 */
public class WebPageValidationTest {
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.gecko.driver", "C:\\Examples\\SeleniumDrivers\\geckodriver.exe"); 
    }
    
    @Test
    public void loginTrueTest() throws InterruptedException{
     					
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://localhost:8080/Restaurants/login.htm";					
        driver.get(baseUrl);	
        WebElement email = driver.findElement(By.id("email"));									
        WebElement password = driver.findElement(By.name("password"));							
        email.sendKeys("Jmo@ymail.com");					
        password.sendKeys("abc");					

        WebElement login = driver.findElement(By.id("submitBtn"));	
        login.click();	
        Thread.sleep(9000);
        String actualPageURL = driver.getCurrentUrl();
        String expectedPageURL = "http://localhost:8080/Restaurants/menuView.htm";
        assertEquals(expectedPageURL,actualPageURL);                			
    }
    
        @Test
    public void loginFalseTest() throws InterruptedException{
     					
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://localhost:8080/Restaurants/login.htm";					
        driver.get(baseUrl);	
        WebElement email = driver.findElement(By.id("email"));									
        WebElement password = driver.findElement(By.name("password"));							
        email.sendKeys("Jmo@ymail.com");					
        password.sendKeys("1abcd");					

        WebElement login = driver.findElement(By.id("submitBtn"));	
        login.click();	
        Thread.sleep(9000);
        String actualPageURL = driver.getCurrentUrl();
        String expectedPageURL = "http://localhost:8080/Restaurants/menuView.htm";
        assertNotEquals(expectedPageURL,actualPageURL); 

    }
    

}
