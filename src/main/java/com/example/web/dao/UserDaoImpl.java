package com.example.web.dao;

import com.example.web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getUsersList() {
        return entityManager.createQuery("SELECT u FROM User u",User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }
}
