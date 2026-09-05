package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;


import java.util.Collections;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Product insert(Product prouduct) {
        Session session = sessionFactory.getCurrentSession();
        prouduct.getProductDetails().setProduct(prouduct);
        session.save(prouduct);
        return prouduct;
    }

    @Override
    public Product findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        return product;

    }

    @Override
    public void deleteById(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Product product = session.get(Product.class, id);
            session.delete(product);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        product.getProductDetails().setProduct(product);
        session.saveOrUpdate(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("FROM Product", Product.class);
        return query.getResultList();
    }
}
