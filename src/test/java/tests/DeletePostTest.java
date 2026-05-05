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

import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class DeletePostTest extends TestBase {

    private PostData post;

    public DeletePostTest(PostData post) {
        this.post = post;
    }

    @Parameterized.Parameters
    public static List<PostData> data() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(new File("posts_delete.xml"), new TypeReference<>() {
        });
    }

    @Test
    public void testDeletePost() {
        AccountData acc = AccountData.validAccount();

        app.getNavigation().openLoginPage();
        app.getAuth().login(acc);

        app.getPost().create(post);

        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        app.getPost().delete();

        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        boolean isPresent = app.getDriver().getPageSource().contains(post.getSubject());
        assertFalse("Ошибка: Пост с заголовком '" + post.getSubject() + "' все еще отображается после удаления!", isPresent);
    }
}