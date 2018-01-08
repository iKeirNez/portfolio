package com.keirnellyer.portfolio.repository;

import com.keirnellyer.portfolio.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class MainRepository implements IMainRepository {
    private SessionFactory sessionFactory;

    public MainRepository() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public List<User> getUsers() {
        Transaction tx = null;

        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            List<User> users = session.createQuery("FROM User", User.class).list();
            tx.commit();
            return users;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }

            throw e;
        }
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query<User> query = session.createQuery("FROM User U WHERE U.username = ?", User.class);
            query.setParameter(1, username);
            query.setFirstResult(0);
            query.setMaxResults(1);
            Optional<User> userOptional = query.uniqueResultOptional();
            transaction.commit();
            return userOptional;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw e;
        }
    }

    @Override
    public int addUser(User user) {
        Transaction tx = null;

        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            int userId = (int) session.save(user);
            tx.commit();
            return userId;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }

            throw e;
        }
    }

    @Override
    public void updateUser(User user) {
        Transaction tx = null;

        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }

            throw e;
        }
    }
}
