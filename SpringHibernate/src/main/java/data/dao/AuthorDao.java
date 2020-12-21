package data.dao;

import data.entity.Author;
import org.hibernate.SessionFactory;
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

    public void update(Author entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public void delete(Author entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
