package pl.sda.springbootstart.dao;

import org.springframework.stereotype.Repository;
import pl.sda.springbootstart.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book){
        entityManager.persist(book);
    }

    public Book get(Long id){
        return entityManager.find(Book.class, id);
    }

    public void delete(Long id){
        Book foundBook = entityManager.find(Book.class, id);
        entityManager.remove(foundBook);
    }

    public Book update(Book book){
        entityManager.merge(book);
        return book;
    }

}
