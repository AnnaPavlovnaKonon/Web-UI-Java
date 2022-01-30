package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//Добавление женского товара в избранное без авторизации

public class AsosAddToFavoriteTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.asos.com/ru");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.xpath("//a[@href='/ru/women/?ctaref=HP|gen|top|women']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='salesBanner__cta js-buttonHover']")));
        driver.findElement(By.xpath("//a[@class='salesBanner__cta js-buttonHover']")).click();

        List<WebElement> stuffList = driver.findElements(By.xpath("//button[@aria-label='Добавить в избранное'] "));
        stuffList.get(0).click();

        driver.findElement(By.xpath("//a[@href='https://www.asos.com/ru/saved-lists/?nlid=nav header']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}

