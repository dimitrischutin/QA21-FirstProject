import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.ElementLocation;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SearchProductTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/");
        //хотим развернуть окно
        // maximize browser to window width
        driver.manage().window().maximize();

        //wait for the site load before starting the test
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Implicite Wait

  //      WebDriverWait wait = new WebDriverWait(driver,30);// Explicit wait
    }

    @Test
    public void searchProductTest() {
        // найти элемент "поле поиска"
        // клик на поле поиска
        // ввести данные в поле
        // проверить, корректен ли результат поиска

        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("summer dresses" + Keys.ENTER);
        String text = driver.findElement(By.className("lighter")).getText();
        System.out.println("##############" + text);
        Assert.assertEquals(text.toLowerCase(Locale.ROOT), "\"summer dresses\"");
    }

    @Test
    public void searchInContainerMenuTest(){
        //find element and click on the first tab in menu content
        WebElement ul = driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']"));
        ul.findElement(By.xpath(".//a[@title='Women']")).click();

        WebElement el = driver.findElement(By.xpath("//ul[@class='tree dynamized']"));

        el.findElement(By.xpath(".//*[contains(text(),'Tops')]")).click();
    }

    @AfterMethod(enabled = false) // игнорирование метода в момент проведения тестирования
    public void tearDown() {
        driver.quit();//закрывает весь сайт
        driver.close(); //закрывает вкладку сайта
    }
}
