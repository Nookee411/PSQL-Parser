package parsers;

import entities.Actor;
import entities.Play;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.print.Doc;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ActorParser {
    String url;

    public ActorParser(String url) {
        this.url = url;
    }

    public List<Actor> parseActors(){
        List<Actor> actors= new LinkedList<>();
        for (int i = 1; i <28; i++) {
            Document doc;
            try {
                doc = Jsoup.connect(url + i).get();
                var actor = new Actor();
                actor.name = doc.getElementsByClass("page_box")
                        .get(1)
                        .getElementsByTag("h1")
                        .get(0)
                        .text();
                doc.getElementsByClass("person").get(0).getElementsByTag("li").forEach(play->{
                    var tempPlay = new Play();
                    tempPlay.title = play.getElementsByTag("a").get(0).text();
                    actor.plays.add(tempPlay);

                });
                actor.link = (url+ i);
                actors.add(actor);
            } catch (IOException
                    e) {
                e.printStackTrace();
            }
        }
        return actors;
    }
}
