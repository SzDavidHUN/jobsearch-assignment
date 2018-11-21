package hu.me.iit.dao;

import org.springframework.stereotype.Repository;

import java.util.Collection;

public interface ObjectRepository<T> {
    Collection<T> getAll();
    void save(T object);
    void saveAll(Iterable<T> iterable);
}
