package com.example.demo.repo;

import com.example.demo.entity.Genres;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class GenreRepoImpl implements GenreRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Genres genres) {
        entityManager.persist(genres);
    }

    @Override
    public Genres findBy(int id) {
        return entityManager.find(Genres.class, id);
    }

    @Override
    public List<Genres> findAllGenres() {
        return (List<Genres>) entityManager.createQuery("select genres from Genres as genres").getResultList();
    }

    @Override
    public boolean exists(String name) {
        return (Long) entityManager.createQuery("select count(genres.name) from Genres as genres where genres.name = :name")
                .setParameter("name", name)
                .getSingleResult() == 1;
    }

}
