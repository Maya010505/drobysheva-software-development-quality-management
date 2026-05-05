package generator;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import data.PostData;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreatePostGenerator {
    public static void main(String[] args) throws IOException {
        int count = 3;
        String filename = "posts_create.xml";

        List<PostData> posts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            posts.add(new PostData("Create Test #" + i, "Контент для создания №" + i));
        }

        new XmlMapper().writeValue(new File(filename), posts);
        System.out.println("Файл " + filename + " готов.");
    }
}