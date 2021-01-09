package entities;


import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

public class Actor {
    public int id;
    public String name;

    public String link;

    public List<Play> plays;
    public Actor(){
        plays = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    public String getName() {
        return this.name;
    }

    public BDActor toBDType(){
        var temp = new BDActor();
        temp.setName(this.name);
        return temp;
    }
}
