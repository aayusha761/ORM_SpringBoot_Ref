package com.example.demo.repo;

import com.example.demo.entity.Books;
import com.example.demo.entity.BooksGenre;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BooksRepoImpl implements BooksRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Books books) {
        entityManager.persist(books);
    }

    @Override
    @Transactional
    public void saveBookGenre(BooksGenre booksGenre) {
        entityManager.persist(booksGenre);
    }

    @Override
    public Books findBy(int id) {
        return entityManager.find(Books.class, id);
    }

    @Override
    public List<Books> findAllBooks() {
        return (List<Books>) entityManager.createQuery("select books from Books as books").getResultList();
    }

    @Override
    public boolean exists(int id) {
        return (Long) entityManager.createQuery("select count(books.bookId) from Books as books where books.bookId = :id")
                .setParameter("id", id)
                .getSingleResult() == 1;
    }

}
