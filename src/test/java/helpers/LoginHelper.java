package helpers;

import data.AccountData;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void login(AccountData acc) {
        if (isLoggedIn()) {
            return;
        }

        manager.getNavigation().openLoginPage();

        type(By.id("user"), acc.getUsername());
        type(By.id("lj_loginwidget_password"), acc.getPassword());
        click(By.name("action:login"));
    }

    public boolean isLoggedIn() {
        return !driver.findElements(By.cssSelector(".s-header-item--post")).isEmpty();
    }
}