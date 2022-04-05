package crud.service;

import crud.dao.UserDao;
import crud.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @PostConstruct
    public void init() {
        create(new User(null, "Tom", "Holland", "tom@holland"));
        create(new User(null, "John", "Smith", "john@smith"));
        create(new User(null, "Mike", "Scott", "mike@scott"));

    }
}