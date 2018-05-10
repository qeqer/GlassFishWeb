package kekdao;

import java.util.List;

public interface GenericDao <T> {
    int create(T newObject);
    T getById(int id);
    void update(T object);
    void delete(T object);
    List<T> getAll();
}
