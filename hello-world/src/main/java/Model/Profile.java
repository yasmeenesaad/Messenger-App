package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profile {
    long id;
    String profileName;
    String fName;
    String lName;
    Date created;
    List<Link> links = new ArrayList<>();

    public Profile() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Profile(String profileName, String fName, String lName) {
        this.profileName = profileName;
        this.fName = fName;
        this.lName = lName;
        this.created = new Date();
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
