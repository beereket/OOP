package News;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

public class News implements Comparable<News>, Serializable {
    
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

    public Date getDate() {
        return date;
    }

    public Vector<String> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return
                "Title:'" + title + '\n' +
                "Content:'" + content + '\n' +
                "Date=" + date + '\n' +
                "Comments=" + comments
                ;
    }

    @Override
    public int compareTo(News o) {
        return this.date.compareTo(o.date);
    }
}
