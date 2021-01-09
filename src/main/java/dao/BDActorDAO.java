package dao;

import entities.Actor;
import entities.BDPlay;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BDActorDAO implements DAO<Actor, Integer> {
    private final SessionFactory factory;

    public BDActorDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(BDPlay actor) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(actor);
            session.getTransaction().commit();
        }
    }

    @Override
    public Actor read(Integer id) {
        try (final Session session = factory.openSession()) {
            final Actor actor = session.get(Actor.class, id);
            if (actor != null) {
                Hibernate.initialize(actor.getName());
            }
            return actor;
        }
    }

    public void update(Actor actor) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(actor);
            session.getTransaction().commit();
        }
    }

    public void delete(Actor actor) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(actor);
            session.getTransaction().commit();
        }
    }
}
