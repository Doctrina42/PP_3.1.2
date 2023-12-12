package com.example.web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.web.model.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    private final EntityManager manager;

    public UserDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void createUser(User user) {
        manager.persist(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return manager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Integer id) {
        return manager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        manager.merge(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        User user = manager.find(User.class, id);
        if (user != null) {
            manager.remove(user);
        }
    }
}