package Homework_16;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class ProductPage extends BasePage {


    @FindBy(xpath = "//*[contains(@class,'inventory_item_name')]")
    private List<WebElement> inventoryItems;

    @FindBy(xpath = "//*[contains(@class,'product_sort_container')]")
    private WebElement sortDropdown;

    @FindBy(xpath = "//*[contains(@class,'inventory_item_price')]")
    private List<WebElement> itemPrices;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickText(String label) {
        driver.findElement(By.xpath("//*[contains(@class,'inventory_item_name')][contains(text(),'" + label + "')]")).click();
    }

    public List<WebElement> getAllInventoryItems() {
        return inventoryItems;
    }

    public void selectSortByPriceLowToHigh() {
        sortDropdown.click();
        driver.findElement(By.xpath("//*[contains(@class,'product_sort_container')]//option[text()='Price (low to high)']")).click();
    }

    public void selectSortByPriceHighToLow() {
        sortDropdown.click();
        driver.findElement(By.xpath("//*[contains(@class,'product_sort_container')]//option[text()='Price (high to low)']")).click();
    }


}