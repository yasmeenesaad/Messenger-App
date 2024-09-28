package Model;

import jakarta.xml.bind.annotation.XmlTransient;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Comment {
    Long id;
    String comment;
    Date created;
    String author;


    public Comment() {
    }
    public Comment(String comment, Date created, String author) {
        this.comment = comment;
        this.created = created;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
