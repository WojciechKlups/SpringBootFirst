package pl.sda.springbootstart.dao;

import org.springframework.stereotype.Repository;
import pl.sda.springbootstart.model.Book;
import pl.sda.springbootstart.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(User user){
        entityManager.persist(user);
    }

    public User get(Long id){
        return entityManager.find(User.class, id);
    }

    public void delete(Long id){
        User foundUser = entityManager.find(User.class, id);
        entityManager.remove(foundUser);
    }

    public User update(User user){
        entityManager.merge(user);
        return user;
    }
}
