package Homewok_16;

import Homewok_16.configuration.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Настройка WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Config.get("base.url"));
    }

    @AfterMethod
    public void tearDown() {
        // Закрытие браузера после теста
        if (driver != null) {
            driver.quit();
        }
    }

    protected void login(String username, String password) {
        // Dвод данных пользователя и вход в систему
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }
}
