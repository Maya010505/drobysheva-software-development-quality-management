package tests;

import data.AccountData;
import data.PostData;
import org.junit.Test;
import pages.LoginPage;
import pages.PostPage;

import static org.junit.Assert.assertTrue;

public class PostTest extends TestBase {

    @Test
    public void userCanCreatePost() {
        AccountData acc = AccountData.validAccount();
        PostData post = PostData.randomPost();

        LoginPage login = new LoginPage(driver);
        PostPage postPage = new PostPage(driver);

        login.open();
        login.login(acc);

        postPage.createPost(post);

        try {Thread.sleep(2000);} catch (InterruptedException e) {}
        assertTrue("Авторизация не удалась", driver.getCurrentUrl().contains("livejournal.com"));
    }
}