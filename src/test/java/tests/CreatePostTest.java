package tests;

import data.AccountData;
import data.PostData;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class CreatePostTest extends TestBase {

    @Test
    public void userCanCreatePost() {
        AccountData acc = AccountData.validAccount();
        PostData post = PostData.randomPost();

        app.getNavigation().openLoginPage();
        app.getAuth().login(acc);

        app.getPost().create(post);

        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        boolean isPostVisible = app.getDriver().getPageSource().contains(post.getSubject());
        assertTrue("Ошибка: Созданный пост не найден на странице!", isPostVisible);
    }
}