package data.dao;

import data.entity.Author;
import data.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorDao implements AbstractDao<Author, Long> {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Author entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public Author findOne(Long id) {
        return sessionFactory.getCurrentSession().get(Author.class, id);
    }

    public List<Author> findAll() {
        TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery("FROM Author ");
        return query.getResultList();
    }

    @Override
    public Author findByName(String name) {
        Author authors;
        Session session = sessionFactory.getCurrentSession();
        Query<Author> query = session.createQuery("SELECT a FROM Author a WHERE lower(a.name) LIKE lower(:name)", Author.class)
                .setParameter("name", name);
        authors = query.getSingleResult();
        return authors;
    }

    public void update(Author entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public void delete(Author entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
