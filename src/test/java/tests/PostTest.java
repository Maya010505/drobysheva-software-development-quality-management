package tests;

import data.AccountData;
import data.PostData;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class PostTest extends TestBase {

    @Test
    public void userCanCreatePost() {
        AccountData acc = AccountData.validAccount();
        PostData post = PostData.randomPost();

        app.getNavigation().openLoginPage();
        app.getAuth().login(acc);

        app.getPost().create(post);

        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        assertTrue(app.getDriver().getCurrentUrl().contains("livejournal.com"));
    }
}