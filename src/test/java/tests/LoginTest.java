package tests;

import data.AccountData;
import org.junit.Test;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends TestBase {

    @Test
    public void validUserCanLogin() {
        AccountData acc = AccountData.validAccount();
        LoginPage login = new LoginPage(driver);

        login.open();
        login.login(acc);

        try {Thread.sleep(2000);} catch (InterruptedException e) {}
        assertTrue("Авторизация не удалась", driver.getCurrentUrl().contains("livejournal.com"));
    }
}