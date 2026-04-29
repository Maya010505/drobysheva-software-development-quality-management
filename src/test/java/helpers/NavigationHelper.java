package helpers;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openLoginPage() {
        if (manager.getAuth().isLoggedIn()) {
            return;
        }

        if (!driver.getCurrentUrl().contains("livejournal.com/login.bml")) {
            driver.get("https://www.livejournal.com/login.bml");
        }
    }
}