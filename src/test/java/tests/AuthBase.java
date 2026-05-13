package tests;

import data.AccountData;
import org.junit.Before;

public class AuthBase extends TestBase {

    @Before
    @Override
    public void setUp() {
        super.setUp();

        app.getAuth().login(AccountData.validAccount());
    }
}