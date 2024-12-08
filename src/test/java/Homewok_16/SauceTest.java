package Homewok_16;

import Homewok_16.configuration.Config;
import Homework_16.MainPage;
import Homework_16.ProductPage;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.testng.Assert.assertTrue;

@Epic("Saucedemo Tests")
@Feature("Inventory Management")
public class SauceTest extends BaseTest {

    private MainPage mainPage;
    private ProductPage productPage;

    @BeforeMethod
    @Override
    @Step("Setting up test environment")
    public void setUp() {
        super.setUp();


        String userLogin = Config.get("user.login");
        String userPassword = Config.get("user.password");

        // Авторизация
        Allure.step("Авторизация пользователя", () -> {
            login(userLogin, userPassword);
        });


        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
    }



    // предоставление списка товаров
    @DataProvider(name = "productNames")
    public Object[][] productNames() {
        return new Object[][]{
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"},
                {"Sauce Labs Onesie"},
                {"Test.allTheThings() T-Shirt (Red)"}
        };
    }

    // Проверка заголовка страницы товаров
    @Test
    @Story("Отображение заголовка страницы товаров")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверяем, что заголовок страницы товаров отображается корректно")
    public void verifyPageTitleTest() {
        Allure.step("Проверяем текст заголовка страницы", () -> {
            WebElement pageTitle = driver.findElement(By.className("title"));
            assertTrue(pageTitle.isDisplayed(), "Заголовок страницы не отображается.");
            assertTrue(pageTitle.getText().equals("Products"), "Неверный текст заголовка страницы.");
        });
    }

    // Тест для проверки наличия товаров в инвентаре
    @Test(dataProvider = "productNames")
    @Story("Проверка наличия товаров")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяем наличие каждого товара из списка на странице товаров")
    public void checkInventoryItemsTest(String productName) {
        // Получение списока всех товаров
        Allure.step("Получение списка всех товаров", () -> {
            List<WebElement> items = productPage.getAllInventoryItems();
            AtomicBoolean productFound = new AtomicBoolean(false);

            // Проверяем наличие товара с заданным названием
            Allure.step("Проверяем наличие товара с названием: " + productName, () -> {
                for (WebElement item : items) {
                    if (item.getText().equals(productName)) {
                        productFound.set(true);
                        break;
                    }
                }
                // Проверяем, что товар найден
                assertTrue(productFound.get(), "Товар с названием '" + productName + "' не найден на странице.");
            });
        });
    }
    // Добавление товара в корзину
    @Test
    @Story("Добавление товара в корзину")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем, что товар можно добавить в корзину")
    public void addToCartTest() {
        Allure.step("Добавляем товар в корзину", () -> {
            WebElement firstItem = productPage.getAllInventoryItems().get(0);
            firstItem.click();
            driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
        });

        Allure.step("Проверяем, что товар добавлен в корзину", () -> {
            WebElement cartIcon = driver.findElement(By.xpath("//*[contains(@class,'shopping_cart_link')]"));
            assertTrue(cartIcon.getText().contains("1"), "Корзина не содержит 1 товар.");
        });
    }
    // Проверка доступности кнопки сортировки
    @Test
    @Story("Доступность кнопки сортировки")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверяем, что элемент сортировки на странице товаров доступен")
    public void verifySortDropdownTest() {
        Allure.step("Проверяем, что кнопка сортировки доступна", () -> {
            WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
            assertTrue(sortDropdown.isDisplayed(), "Элемент сортировки не отображается.");
            assertTrue(sortDropdown.isEnabled(), "Элемент сортировки недоступен для взаимодействия.");
        });
    }

}
