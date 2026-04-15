package data;

public class PostData {
    private final String subject;
    private final String content;

    public PostData(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public String getSubject() { return subject; }
    public String getContent() { return content; }

    public static PostData randomPost() {
        String ts = String.valueOf(System.currentTimeMillis());
        return new PostData("Тест #" + ts, "Авто-тест: " + ts);
    }
}