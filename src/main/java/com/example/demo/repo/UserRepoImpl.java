package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findBy(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) entityManager.createQuery("select user from User as user").getResultList();
    }

    @Override
    public boolean exists(String email) {
        return (Long) entityManager.createQuery("select count(user.email) from User as user where user.email = :email")
                .setParameter("email", email)
                .getSingleResult() == 1;
    }
}