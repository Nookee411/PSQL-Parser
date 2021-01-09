import entities.BDPlay;
import entities.Play;
import parsers.ActorParser;
import parsers.PlayParser;
import readers.PlayReader;
import savers.ActorSaver;
import savers.PlaySaver;

import java.sql.SQLException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
            ActorParser parser = new ActorParser("https://kirovdramteatr.ru/person/");
        var actors = parser.parseActors();
        ActorSaver saver = new ActorSaver();
        PlayParser playParser = new PlayParser();
        var plays = playParser.parsePlays();

        PlaySaver.savePlays(convertForBD((LinkedList<Play>) plays));
        LinkedList<BDPlay> playsFromBD = null;
        try {
            playsFromBD = (LinkedList<BDPlay>) PlayReader.readPlays();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Table parsed successfully");
        System.out.println(playsFromBD);
    }

    private static LinkedList<BDPlay> convertForBD(LinkedList<Play> plays){
        var res = new LinkedList<BDPlay>();
        for (Play play : plays) {
            res.add(play.convertForBD());
        }
        return res;
    }
}
