package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HelperBase {
    protected ApplicationManager manager;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
        this.driver = manager.getDriver();
        // Ожидание до 10 секунд
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Вспомогательный метод для ожидания и поиска
    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        // Сначала ждем, потом кликаем
        find(locator).click();
    }

    protected void type(By locator, String text) {
        if (text != null) {
            WebElement element = find(locator);
            element.clear();
            element.sendKeys(text);
        }
    }
}