package entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "play")
public class BDPlay {
    @Id
    @Column(name = "title")
    private String title;

    @Column(name="link")
    private String link;
    public BDPlay() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "BDPlay{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
