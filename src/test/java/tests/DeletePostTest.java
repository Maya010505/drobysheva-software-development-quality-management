package tests;

import data.AccountData;
import data.PostData;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class DeletePostTest extends TestBase {

    @Test
    public void testDeletePost() {
        AccountData acc = AccountData.validAccount();
        PostData post = PostData.randomPost();

        app.getNavigation().openLoginPage();
        app.getAuth().login(acc);

        app.getPost().create(post);

        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        app.getPost().delete();

        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        boolean isPresent = app.getDriver().getPageSource().contains(post.getSubject());
        assertFalse("Ошибка: Пост все еще отображается после удаления!", isPresent);
    }
}