package dao;

import entities.BDPlay;
import entities.Play;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BDPlayDAO implements DAO<BDPlay, Integer>{

    private final SessionFactory factory;

    public BDPlayDAO(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(BDPlay play) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(play);
            session.getTransaction().commit();
        }
    }

    @Override
    public BDPlay read(Integer id) {
        try (final Session session = factory.openSession()) {
            final BDPlay play = session.get(BDPlay.class, id);
            if (play != null) {
                Hibernate.initialize(play.getTitle());
            }
            return play;
        }
    }

    public void update(BDPlay actor) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(actor);
            session.getTransaction().commit();
        }
    }

    public void delete(BDPlay play) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(play);
            session.getTransaction().commit();
        }
    }
}
