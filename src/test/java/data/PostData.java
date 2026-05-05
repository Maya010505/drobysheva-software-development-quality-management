package data;

public class PostData {
    private String subject;
    private String content;

    public PostData() {}

    public PostData(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public String getSubject() { return subject; }
    public String getContent() { return content; }
}