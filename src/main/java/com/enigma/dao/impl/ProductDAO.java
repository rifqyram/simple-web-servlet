package com.enigma.dao.impl;

import com.enigma.config.HibernateConfig;
import com.enigma.dao.DAO;
import com.enigma.entity.Product;
import com.enigma.error.NotFoundError;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class ProductDAO implements DAO<Product, Long> {

    @Override
    public Product getById(Long id) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    @Override
    public List<Product> findAll() {
        Session session = HibernateConfig.getSessionFactory().openSession();

        List<Product> products;
        Query query = session.createQuery("FROM Product ORDER BY id DESC");
        products = query.getResultList();
        session.close();
        return products;
    }

    @Override
    public void save(Product product) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Product product) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.update(product);
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
            Product product = getById(id);
            System.out.println(product);
            if (product != null) {
                session.delete(product);
            } else {
                throw new NotFoundError(String.format("not found %s with id %d",Product.class.getSimpleName(), id));
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
