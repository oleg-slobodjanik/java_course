package com.slobodianyk.homework4.repositories;

import com.slobodianyk.homework4.util.HibernateUtil;
import com.slobodianyk.homework4.models.Role;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;

public class RoleRepository {

    public Role create(Role role) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(role); // Використовуємо persist замість save
            transaction.commit();
        }
        return role;
    }

    public Optional<Role> findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Role.class, id));
        }
    }
}
