package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/ru/women/?ctaref=HP|gen|top|women']")
    private WebElement chooseSexButton;

    @Step("Выбрать раздел Женское")
    public MainPage clickChooseSexButton() {
        chooseSexButton.click();
        return this;
    }

    private final static String BUY_BUTTON_LOCATOR = "//a[@class='salesBanner__cta js-buttonHover']";
    @FindBy(xpath = BUY_BUTTON_LOCATOR)
    private WebElement buyButton;

    @Step("Нажать кнопку Купить")
    public StuffPage clickBuyButton() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUY_BUTTON_LOCATOR)));
        buyButton.click();
        return new StuffPage(driver);
    }
}
