package mx.utng.s26.sesion26.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.s26.sesion26.model.entity.Book;

@Repository
public class BookDaoImpl implements IBookDao{
    
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<Book> list() {
        return em.createQuery("from Book").getResultList();
    }

    @Override
    public void save(Book book) {
        if(book.getId() != null && book.getId() >0){
            em.merge(book);
        }else{
            em.persist(book);
        }
    }

    @Override
    public Book getById(Long id) {
        return em.find(Book.class, id);
    }

    @Override
    public void delete(Long id) {
        Book book = getById(id);
        em.remove(book);
    }
}
