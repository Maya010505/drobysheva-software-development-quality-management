package generator;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import data.PostData;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeletePostGenerator {
    public static void main(String[] args) throws IOException {
        int count = 2;
        String filename = "posts_delete.xml";

        List<PostData> posts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            posts.add(new PostData("Delete Me #" + i, "Этот пост будет удален вручную №" + i));
        }

        new XmlMapper().writeValue(new File(filename), posts);
        System.out.println("Файл " + filename + " готов.");
    }
}