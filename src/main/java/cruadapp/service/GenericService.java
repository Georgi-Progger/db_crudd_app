package cruadapp.service;

import cruadapp.repository.GenericRepository;

import java.sql.SQLException;
import java.util.List;

public interface GenericService<T, ID> {
    T create(T t);
    T readOne(ID id);
    List<T> readAll();
    void update(T t);
    void delete(ID id);
}
