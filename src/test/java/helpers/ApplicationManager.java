package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    private WebDriver driver;
    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;
    private PostHelper postHelper;

    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<>();

    private ApplicationManager() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        navigationHelper = new NavigationHelper(this);
        loginHelper = new LoginHelper(this);
        postHelper = new PostHelper(this);

        Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
    }

    public static ApplicationManager getInstance() {
        if (app.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            app.set(newInstance);
        }
        return app.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public NavigationHelper getNavigation() {
        return navigationHelper;
    }

    public LoginHelper getAuth() {
        return loginHelper;
    }

    public PostHelper getPost() {
        return postHelper;
    }
}