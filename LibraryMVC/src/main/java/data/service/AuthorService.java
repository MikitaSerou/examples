package data.service;

import data.dao.AbstractDao;
import data.dao.AuthorDao;
import data.entity.Author;
import data.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("as")
@Scope("prototype")
public class AuthorService implements AbstractService<Author, Long> {

    @Autowired
    AbstractDao<Author, Long> authorDao;

    @Transactional
    public void add(Author entity) {
        authorDao.save(entity);
    }

    @Transactional
    public Author findOne(Long id) {
        return authorDao.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<Author> list() {
        return authorDao.findAll();
    }

    @Transactional
    @Override
    public Author findByName(String name) {
        return authorDao.findByName(name);
    }

    @Transactional
    public void update(Author entity) {
        authorDao.update(entity);
    }

    @Transactional
    public void delete(Author entity) {
        authorDao.delete(entity);
    }

    @Transactional
    public List<Book> getBooks(Author author){
        return author.getBooks();
    }


    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }
}
