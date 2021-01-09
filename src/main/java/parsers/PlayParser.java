package parsers;

import entities.Actor;
import entities.Play;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PlayParser {
    String url;

    public PlayParser() {
        url = "https://kirovdramteatr.ru/shows/";
    }
    public List<Play> parsePlays(){
        LinkedList<Play> plays = new LinkedList<>();
        for (int i = 1; i < 100; i++) {
            Play temp = new Play();
            try {
                Document doc = null;
                try {
                    doc = Jsoup.connect((url + i)).get();
                }catch (HttpStatusException ex){
                    continue;
                }
                temp.title  = doc.getElementById("col2").getElementsByTag("h1").get(0).text();
                if(temp.title.equals(""))
                    temp.title = "10";
                LinkedList<Actor> actorList = new LinkedList<>();
                var persons = doc.getElementsByClass("person");
                if(persons.size()>0)
                persons.get(1).getElementsByTag("li").forEach(actor->{
                    Actor tempActor = new Actor();
                    var tempList = actor.getElementsByTag("a");

                    if(tempList.size()>0) {
                        var tempEle = tempList.get(0);
                        tempActor.name = tempEle.text();
                        tempActor.link = tempEle.attr("href");
                        actorList.add(tempActor);
                    }


                });
                temp.actors = (LinkedList<Actor>) actorList.clone();
            } catch (IOException e) {
                e.printStackTrace();
            }
            plays.add(temp);

        }
        System.out.println(plays);

        return plays;
    }
}
