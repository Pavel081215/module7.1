package com.hibernate.base.dao.hibernate;

import com.hibernate.base.dao.DishInKitchenDao;
import com.hibernate.base.model.DishInKitchen;
import com.hibernate.base.model.Stock;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Pavel on 18.07.2016.
 */
public class HDishInKichenDao implements DishInKitchenDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(DishInKitchen dishInKitchen) {
        sessionFactory.getCurrentSession().save(dishInKitchen);
    }

    @Override
    public Stock load(Long id) {
        return sessionFactory.getCurrentSession().load(Stock.class ,id);
    }

    @Override
    public List<DishInKitchen> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from DishInKitchen e").list() ;
    }

    @Override
    public void remove(DishInKitchen dishInKitchen) {
        sessionFactory.getCurrentSession().delete(dishInKitchen);
    }

    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from DishInKitchen").executeUpdate() ;
    }

    @Override
    public Stock findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select  e from DishInKitchen e  where  e.name like :name");
        query.setParameter("name", name);
        return (Stock) query.uniqueResult();
    }
}
