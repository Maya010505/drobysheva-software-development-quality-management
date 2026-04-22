package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    private WebDriver driver;
    
    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;
    private PostHelper postHelper;

    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Инициализируем помощников, передавая им ссылку на этот менеджер (this)
        navigationHelper = new NavigationHelper(this);
        loginHelper = new LoginHelper(this);
        postHelper = new PostHelper(this);
    }

    public void stop() {
        driver.quit();
    }

    // Геттеры для доступа к помощникам (Property в C#)
    public WebDriver getDriver() { return driver; }
    public NavigationHelper getNavigation() { return navigationHelper; }
    public LoginHelper getAuth() { return loginHelper; }
    public PostHelper getPost() { return postHelper; }
}