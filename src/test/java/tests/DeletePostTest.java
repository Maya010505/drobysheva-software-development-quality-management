package tests;

import data.PostData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class DeletePostTest extends AuthBase {

    private PostData post;

    public DeletePostTest(PostData post) {
        this.post = post;
    }

    @Parameterized.Parameters
    public static List<PostData> data() throws Exception {
        return new XmlMapper().readValue(new File("posts_delete.xml"), new TypeReference<List<PostData>>() {
        });
    }

    @Test
    public void testDeletePost() {
        app.getPost().create(post);
        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        app.getPost().delete();
        try { Thread.sleep(3000); } catch (InterruptedException e) { }

        boolean isPresent = app.getDriver().getPageSource().contains(post.getSubject());
        assertFalse("Ошибка: Пост не удален!", isPresent);
    }
}