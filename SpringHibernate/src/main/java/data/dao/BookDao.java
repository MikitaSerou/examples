package data.dao;

import data.entity.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookDao implements AbstractDao<Book, Long> {

    @Autowired
    private SessionFactory sessionFactory;


    public void save(Book entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public Book findOne(Long id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }


    public List<Book> findAll() {
        TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery("FROM Book");
        return query.getResultList();
    }

    public void update(Book entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public void delete(Book entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
