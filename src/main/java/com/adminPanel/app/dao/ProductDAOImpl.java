package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public Product findById(Long  id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        return product;

    }

    @Override
    public void deleteById(Long  id) {
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

    @Override
    public List<Product> findByName(String name) {

        Session session = sessionFactory.getCurrentSession();

        Query<Product> query =
                session.createQuery(
                        "from Product where name=:name",
                        Product.class);

        query.setParameter("name", name);

        return query.getResultList();
    }}
