package savers;

import dao.BDPlayDAO;
import entities.BDPlay;
import entities.Play;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.LinkedList;

public class PlaySaver {
    private static SessionFactory factory = null;

    public static void savePlays(LinkedList<BDPlay> plays){
        factory = new Configuration().configure().buildSessionFactory();
        var playDao = new BDPlayDAO(factory);
        plays.forEach(play->playDao.create(play));
        System.out.println("Input to db finished");
    }
}
