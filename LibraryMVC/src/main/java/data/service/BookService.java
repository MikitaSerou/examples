package data.service;

import data.dao.AbstractDao;
import data.dao.BookDao;
import data.entity.Author;
import data.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("bs")
@Scope("prototype")
public class BookService implements AbstractService<Book, Long> {


    @Autowired
    AbstractDao<Book, Long> bookDao;

    @Transactional
    @Override
    public void add(Book entity) {
        bookDao.save(entity);
    }

    @Transactional
    @Override
    public Book findOne(Long id) {
        return bookDao.findOne(id);
    }

    @Transactional
    @Override
    public Book findByName(String name) {
        return bookDao.findByName(name);
    }

    @Transactional
    @Override
    public List<Book> list() {
        return bookDao.findAll();
    }

    @Transactional
    @Override
    public void update(Book entity) {
        bookDao.update(entity);
    }

    @Transactional
    @Override
    public void delete(Book entity) {
        bookDao.delete(entity);
    }


    public List<Author> getAuthors(Book book) {
        return book.getAuthors();
    }


    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }


}
