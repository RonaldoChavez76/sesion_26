package mx.utng.s26.sesion26.model.dao;

import java.util.List;
import mx.utng.s26.sesion26.model.entity.Book;

public interface IBookDao {
    List<Book> list();
    void save(Book book);
    Book getById(Long id);
    void delete(Long id);
}
