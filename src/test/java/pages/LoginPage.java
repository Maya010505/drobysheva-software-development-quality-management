package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import data.AccountData;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By username = By.id("user");
    private By password = By.id("lj_loginwidget_password");
    private By loginBtn = By.name("action:login");

    public void open() {
        driver.get("https://www.livejournal.com/login.bml");
    }

    public void login(AccountData acc) {
        type(username, acc.getUsername());
        type(password, acc.getPassword());
        click(loginBtn);
    }
}