package tests;

import helpers.ApplicationManager;
import org.junit.Before;

public class TestBase {
    protected ApplicationManager app;

    @Before
    public void setUp() {
        app = ApplicationManager.getInstance();
        app.getNavigation().openLoginPage();
    }
}