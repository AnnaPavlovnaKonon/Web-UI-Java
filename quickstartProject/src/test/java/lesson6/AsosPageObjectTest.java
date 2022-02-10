package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AsosPageObjectTest {
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
    @Feature("Избранное")
    @Description("Добавление женского товара в избранное без авторизации")
    void addToFavouriteTest() {
        new MainPage(driver)
                .clickChooseSexButton()
                .clickBuyButton()
                .clickAddToFavouriteButton()
                .clickFavouriteButton()
                .checkStuffSavedInFavourite();
    }

    @Test
    @Feature("Избранное")
    @Description("Удаление женского товара из избранного без авторизации")
    void deleteFromFavouriteTest() {
        new MainPage(driver)
                .clickChooseSexButton()
                .clickBuyButton()
                .clickAddToFavouriteButton()
                .clickFavouriteButton()
                .checkStuffSavedInFavourite()
                .clickDeleteFromFavouriteButton()
                .checkStuffDeletedFromFavourite();
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
