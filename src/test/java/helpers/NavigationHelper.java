package helpers;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openLoginPage() {
        driver.get("https://www.livejournal.com/login.bml");
    }
}