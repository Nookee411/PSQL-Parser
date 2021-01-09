package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

public class Play {
    @Column(name = "title")
    public String title;

    public LinkedList<Actor> actors;
    private String link;


    public String getTitle() {
        return title;
    }

    public Play() {
        actors = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Play{" +
                "title='" + title + '\'' +
                ", actors=" + actors +
                '}';
    }

    public BDPlay convertForBD(){
        var temp = new BDPlay();
        temp.setTitle(this.title);
        temp.setLink(this.link);
        return temp;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedList<Actor> getActors() {
        return actors;
    }

    public void setActors(LinkedList<Actor> actors) {
        this.actors = actors;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
