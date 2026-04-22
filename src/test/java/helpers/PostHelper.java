package helpers;

import data.PostData;
import org.openqa.selenium.By;

public class PostHelper extends HelperBase {

    public PostHelper(ApplicationManager manager) {
        super(manager);
    }

    public void create(PostData post) {
        click(By.cssSelector(".s-header-item--post a.s-header-button-blue"));
        type(By.cssSelector(".text-0-2-139"), post.getSubject());
        type(By.cssSelector(".notranslate"), post.getContent());
        click(By.cssSelector(".js--toggle-submission-popup"));
        click(By.cssSelector(".js--submit-post"));
    }
}