package crud.dao;

import crud.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();

    }
}
