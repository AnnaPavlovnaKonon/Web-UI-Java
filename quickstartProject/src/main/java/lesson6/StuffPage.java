package lesson6;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StuffPage extends BasePage {
    public StuffPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@aria-label='Добавить в избранное']")
    private List<WebElement> stuffList;

    public StuffPage clickAddToFavouriteButton() {
        stuffList.get(0).click();
        return this;
    }

    @FindBy(xpath = "//a[@href='https://www.asos.com/ru/saved-lists/?nlid=nav header']")
    private WebElement favouriteButton;

    public FavouritePage clickFavouriteButton() {
        favouriteButton.click();
        return new FavouritePage(driver);
    }

   /* List<WebElement> stuffList = driver.findElements(By.xpath("//button[@aria-label='Добавить в избранное'] "));
        stuffList.get(0).click();

    driver.findElement(By.xpath("//a[@href='https://www.asos.com/ru/saved-lists/?nlid=nav header']")).click();*/

}
