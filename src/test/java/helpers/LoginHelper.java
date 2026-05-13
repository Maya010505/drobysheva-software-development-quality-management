package helpers;

import data.AccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void login(AccountData acc) {
        if (isLoggedIn()) {
            if (isLoggedIn(acc.getUsername())) {
                return;
            }
            logout();
        }

        manager.getNavigation().openLoginPage();
        type(By.id("user"), acc.getUsername());
        type(By.id("lj_loginwidget_password"), acc.getPassword());
        click(By.name("action:login"));
    }

    public void logout() {
        if (isLoggedIn()) {
            Actions actions = new Actions(driver);
            WebElement userMenu = driver.findElement(By.cssSelector(".s-header-item--user"));
            actions.moveToElement(userMenu).perform();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".s-header-sub-list-item__link--logout"))).click();
            if (!driver.findElements(By.name("action:logout")).isEmpty()) {
                click(By.name("action:logout"));
            }
        }
    }

    public boolean isLoggedIn() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        return !driver.findElements(By.cssSelector(".s-header-item--post")).isEmpty();
    }

    public boolean isLoggedIn(String username) {
        if (!isLoggedIn()) return false;

        String source = driver.getPageSource().toLowerCase();
        return source.contains(username.toLowerCase());
    }
}