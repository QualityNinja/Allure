package Homework_16;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private ProductPage input;

    public MainPage(WebDriver driver) {
        super(driver);
        this.input = new ProductPage(driver);
    }

    public void click(String label) {
        input.clickText(label);
    }
}