package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "actors")
public class BDActor {
    @Id
    @Column(name = "actor_id")
    private int ID;
    @Column(name = "actor_name")
    private String name;

    //private List<Play> plays;

    public BDActor() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Play> getPlays() {
//        return plays;
//    }
//
//    public void setPlays(List<Play> plays) {
//        this.plays = plays;
//    }
}
