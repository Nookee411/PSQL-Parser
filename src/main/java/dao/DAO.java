package dao;

import entities.BDPlay;

public interface DAO<Entity, Key> {
    void create(BDPlay play);
    Entity read(Key key);
    void update(Entity entity);
    void delete(Entity entity);
}
