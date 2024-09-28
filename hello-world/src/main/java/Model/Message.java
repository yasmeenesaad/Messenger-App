package Model;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.*;

public class Message {
    String message;
    Long id;
    Date created;
    String author;
    private Map<Long, Comment> comments = new HashMap<>();
    List<Link> links = new ArrayList<>();
    @XmlTransient
    public Map<Long, Comment> getComments() {
        return comments;
    }

    public void setComments(Map<Long, Comment> comments) {
        this.comments = comments;
    }
    public Message() {
    }

    public Message(Long id, String message,  String author) {
        this.message = message;
        this.id = id;
        this.created = new Date();
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
    public void addLink(String url,String rel)
    {
        Link link = new Link();
        link.setRel(rel);
        link.setLink(url);
        links.add(link);
    }
}
