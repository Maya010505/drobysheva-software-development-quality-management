package tests;

import data.PostData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CreatePostTest extends AuthBase {

    private PostData post;

    public CreatePostTest(PostData post) {
        this.post = post;
    }

    @Parameterized.Parameters
    public static List<PostData> data() throws Exception {
        return new XmlMapper().readValue(new File("posts_create.xml"), new TypeReference<List<PostData>>() {
        });
    }

    @Test
    public void userCanCreatePost() {
        app.getPost().create(post);

        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        boolean isPostVisible = app.getDriver().getPageSource().contains(post.getSubject());
        assertTrue("Ошибка: Пост не найден!", isPostVisible);
    }
}