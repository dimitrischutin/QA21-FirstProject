package com.telran.qa21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TableTests {

    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test

    public void tableTestCss() {
        WebElement element = wd.findElement(By.cssSelector("tr:nth-child(8) td:last-child"));
        String text = element.getText();
        System.out.println(text);
        Assert.assertEquals(text,"Canada");
        Assert.assertTrue(text.contains("Can"));
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        wd.quit();
    }
}
