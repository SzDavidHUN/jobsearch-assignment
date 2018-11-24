package hu.me.iit.dao;

import java.util.Collection;

public interface CreatReadRepository<T, ID> {

    <S extends T> S save(S var1);

    <S extends T> Iterable<S> saveAll(Iterable<S> var1);

    Collection<T> findAll();

    long count();

}
