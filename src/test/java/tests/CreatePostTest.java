package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import data.AccountData;
import data.PostData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CreatePostTest extends TestBase {

    private PostData post;

    public CreatePostTest(PostData post) {
        this.post = post;
    }

    @Parameterized.Parameters
    public static List<PostData> data() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(new File("posts_create.xml"), new TypeReference<>() {
        });
    }

    @Test
    public void userCanCreatePost() {
        AccountData acc = AccountData.validAccount();

        app.getNavigation().openLoginPage();
        app.getAuth().login(acc);

        app.getPost().create(post);

        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        boolean isPostVisible = app.getDriver().getPageSource().contains(post.getSubject());
        assertTrue("Ошибка: Созданный пост не найден на странице!", isPostVisible);
    }
}