package org.example.dao;

import org.example.exception.DtoException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Optional;

public abstract class AbstractDao<T> {
    protected final SessionFactory sessionFactory;
    protected final Class<T> clazz;

    public AbstractDao(SessionFactory sessionFactory, Class<T> clazz) {
        this.sessionFactory = sessionFactory;
        this.clazz = clazz;
    }

    public Optional<T> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(clazz, id));
        } catch (Exception e) {
            throw new DtoException("Can not get " + clazz.getSimpleName() + "with id " + id, e);
        }
    }

    public T add(T t) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
            return t;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DtoException("Can not create " + clazz.getSimpleName() + " " + t, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
