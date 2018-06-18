package com.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.nio.file.FileSystems;

/**
 * @author cbuelvasc
 */
public class BaseTest {

    private static String PAGE_URL = "https://www.youtube.com/";
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
       System.setProperty("webdriver.chrome.driver",
               FileSystems.getDefault().getPath("src/main/resources/chromedriver").toString());
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        driver.manage().window().maximize();
    }

    @Test
    public void testHomepage() {
        WebElement elementSearch = driver.findElement(By.id("search"));
        elementSearch.sendKeys("Metallica One");

        WebElement elementIcon = driver.findElement(By.id("search-icon-legacy"));
        elementIcon.click();
    }


    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
