package mx.utng.s26.sesion26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.s26.sesion26.model.dao.IBookDao;

import mx.utng.s26.sesion26.model.entity.Book;

@Service
public class BookServiceImpl implements IBookService{
   @Autowired
    private IBookDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<Book> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(Book book) {
        dao.save(book);
    }

    @Transactional(readOnly = true)
    @Override
    public Book getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    } 
}
