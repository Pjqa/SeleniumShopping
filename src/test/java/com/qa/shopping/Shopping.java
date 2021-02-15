package com.qa.shopping;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Shopping {
	
	private static RemoteWebDriver driver;
	private static WebElement target;
	

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome/chromedriver.exe");
        driver = new ChromeDriver(chromeCfg());
        
    }
    
    @AfterClass
    public static void cleanUp() {
    	driver.quit();
    	System.out.println("Driver Closed");
    }
    
    public static ChromeOptions chromeCfg() {
     Map<String, Object> prefs = new HashMap<String, Object>();
     ChromeOptions cOptions = new ChromeOptions();
      
     prefs.put("profile.default_content_setting_values.cookies", 2);
     prefs.put("network.cookie.cookieBehavior", 2);
     prefs.put("profile.block_third_party_cookies", true);

     cOptions.setExperimentalOption("prefs", prefs);

     return cOptions;
     }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        target = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/input[4]"));
        target.sendKeys("dress");
        target.submit();
        target = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
        target.click();
        
        assertEquals("Printed Dress", driver.findElement(By.xpath("/html/body/div/div[2]/div/div[4]/div/div/div/div[3]/h1")).getText());
        
        Thread.sleep(500);
    }

}
