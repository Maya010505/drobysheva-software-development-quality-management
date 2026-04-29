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

    public void delete() {
        click(By.cssSelector(".svgicon--more"));
        click(By.linkText("Редактировать запись"));
        click(By.linkText("Удалить пост"));
        click(By.cssSelector(".reset-0-2-234:nth-child(2) > .rootIn-0-2-243"));
    }
}