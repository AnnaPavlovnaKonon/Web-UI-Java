package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class FavouritePage extends BasePage{
    public FavouritePage(WebDriver driver) {
        super(driver);
    }

    private final static String IS_SAVED_LOCATOR = "//div[.='1 шт. сохранено']";
    @FindBy (xpath = IS_SAVED_LOCATOR)
    private WebElement isSavedInFavourite;

    @Step("Проверить, что товар добвален в избранное")
    public FavouritePage checkStuffSavedInFavourite() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Избранное']")));
        assertThat(isSavedInFavourite, isDisplayed());
        return this;
    }

    @FindBy (xpath = "//button[@aria-label='Удалить']")
    private WebElement deleteFromFavouriteButton;

    @Step("Нажать кнопку Удалить")
    public FavouritePage clickDeleteFromFavouriteButton() {
        deleteFromFavouriteButton.click();
        return this;
    }

    private final static String NO_SAVED_STUFF_LOCATOR = "//h2[.='Нет сохраненных товаров']";
    @FindBy (xpath = NO_SAVED_STUFF_LOCATOR)
    private WebElement noSavedStuff;

    @Step("Проверить, что товар удален из избранного")
    public FavouritePage checkStuffDeletedFromFavourite() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NO_SAVED_STUFF_LOCATOR)));
        assertThat(noSavedStuff, isDisplayed());
        return this;
    }

/*    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Избранное']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[.='1 шт. сохранено']")).isDisplayed());
    driver.findElement(By.xpath("//button[@aria-label='Удалить']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[.='Нет сохраненных товаров']")));*/

}
