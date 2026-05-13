package helpers;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openLoginPage() {
        if (manager.getAuth().isLoggedIn()) {
            return;
        }
        driver.get(Settings.getBaseUrl());
    }
}