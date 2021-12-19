package com.enigma.dao.impl;

import com.enigma.config.HibernateConfig;
import com.enigma.dao.DAO;
import com.enigma.entity.Customer;
import com.enigma.error.NotFoundError;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class CustomerDAO implements DAO<Customer, Long> {

    @Override
    public Customer getById(Long id) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        Session session = HibernateConfig.getSessionFactory().openSession();

        Query query = session.createQuery("FROM Customer ORDER BY id DESC");
        List<Customer> resultList = query.getResultList();
        session.close();
        return resultList;
    }

    @Override
    public void save(Customer customer) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            session.save(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Customer customer) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.update(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Customer customer = getById(id);
            System.out.println(customer);
            if (customer != null) {
                session.delete(customer);
            } else {
                throw new NotFoundError(String.format("not found %s with id %d", Customer.class.getSimpleName(), id));
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
