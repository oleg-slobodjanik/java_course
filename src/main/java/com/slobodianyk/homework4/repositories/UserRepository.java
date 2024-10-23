package com.slobodianyk.homework4.repositories;

import com.slobodianyk.homework4.util.HibernateUtil;
import com.slobodianyk.homework4.models.User;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;

public class UserRepository {

    public User create(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user); // Використовуємо persist замість save
            transaction.commit();
        }
        return user;
    }

    public Optional<User> findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(User.class, id));
        }
    }

    public User update(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(user); // Використовуємо merge для оновлення
            transaction.commit();
        }
        return user;
    }
}
