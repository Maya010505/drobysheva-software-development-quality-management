package tests;

import data.AccountData;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LoginTest extends TestBase {

    @Test
    public void validUserCanLogin() {
        AccountData acc = AccountData.validAccount();

        app.getNavigation().openLoginPage();
        app.getAuth().login(acc);

        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        assertTrue(app.getDriver().getCurrentUrl().contains("livejournal.com"));
    }
}