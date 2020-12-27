package data.dao;

import data.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

    @Override
    public Book findByName(String name) {
        Book book;
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("select b from Book b WHERE lower(b.name) LIKE lower(:name)", Book.class)
                .setParameter("name", name);
        book = query.getSingleResult();
        return book;
    }

    public void update(Book entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public void delete(Book entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
