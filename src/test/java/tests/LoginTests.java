package tests;

import data.AccountData;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTests extends TestBase {

    @Test
    public void loginWithValidData() {
        app.getAuth().logout();

        AccountData acc = AccountData.validAccount();
        app.getAuth().login(acc);

        assertTrue("Ошибка: Не удалось войти под валидным пользователем",
                app.getAuth().isLoggedIn(acc.getUsername()));
    }

    @Test
    public void loginWithInvalidData() {
        app.getAuth().logout();

        AccountData invalidAcc = new AccountData("bad_user_name", "bad_password");
        app.getAuth().login(invalidAcc);

        assertFalse("Ошибка: Система пустила пользователя с неверными данными",
                app.getAuth().isLoggedIn());
    }
}