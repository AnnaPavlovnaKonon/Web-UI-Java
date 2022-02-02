package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AsosTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String ASOS_URL = "https://asos.com/ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(ASOS_URL);
    }

    @Test
    void addToFavouriteTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/ru/women/?ctaref=HP|gen|top|women']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='salesBanner__cta js-buttonHover']")));
        driver.findElement(By.xpath("//a[@class='salesBanner__cta js-buttonHover']")).click();

        List<WebElement> stuffList = driver.findElements(By.xpath("//button[@aria-label='Добавить в избранное'] "));
        stuffList.get(0).click();

        driver.findElement(By.xpath("//a[@href='https://www.asos.com/ru/saved-lists/?nlid=nav header']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Избранное']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[.='1 шт. сохранено']")).isDisplayed());
    }

    @Test
    void deleteFromFavouriteTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/ru/women/?ctaref=HP|gen|top|women']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='salesBanner__cta js-buttonHover']")));
        driver.findElement(By.xpath("//a[@class='salesBanner__cta js-buttonHover']")).click();

        List<WebElement> stuffList = driver.findElements(By.xpath("//button[@aria-label='Добавить в избранное'] "));
        stuffList.get(0).click();

        driver.findElement(By.xpath("//a[@href='https://www.asos.com/ru/saved-lists/?nlid=nav header']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Избранное']")));
        driver.findElement(By.xpath("//button[@aria-label='Удалить']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[.='Нет сохраненных товаров']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//h2[.='Нет сохраненных товаров']")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
