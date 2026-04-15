package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import data.PostData;

public class PostPage extends BasePage {

    public PostPage(WebDriver driver) {
        super(driver);
    }

    private By newPost = By.cssSelector(".s-header-item--post a.s-header-button-blue");
    private By title = By.cssSelector(".text-0-2-139");
    private By body = By.cssSelector(".notranslate");
    private By openPublish = By.cssSelector(".js--toggle-submission-popup");
    private By submit = By.cssSelector(".js--submit-post");

    public void createPost(PostData post) {
        click(newPost);
        type(title, post.getSubject());
        type(body, post.getContent());

        click(openPublish);
        click(submit);
    }
}