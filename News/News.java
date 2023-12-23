package News;

import java.util.Date;
import java.util.Vector;

public class News implements Comparable<News> {
    
    private String title;
    private String content;
    private Date date;
    private Vector<String> comments = new Vector<String>();

    //CONSTRUCTORS
    public News(String title, String content) {
        this.title = title;
        this.content = content;
        date = new Date();
    }
    //GETTER AND SETTER


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void addComment(String comment){
        comments.add(comment);
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", comments=" + comments +
                '}';
    }

    @Override
    public int compareTo(News o) {
        return this.date.compareTo(o.date);
    }
}
