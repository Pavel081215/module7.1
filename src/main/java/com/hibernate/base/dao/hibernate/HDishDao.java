package com.hibernate.base.dao.hibernate;

import com.hibernate.base.dao.DishDao;
import com.hibernate.base.model.Dish;
import com.hibernate.base.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pavel on 08.07.2016.
 */
public class HDishDao implements DishDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);

    }
    @Transactional
    @Override
    public Employee load(Long id) {
        return null;
    }
    @Transactional
    @Override
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from Dish e").list() ;
    }
    @Transactional
    @Override
    public void remove(Dish dish) {
        sessionFactory.getCurrentSession().delete(dish);
    }
    @Transactional
    @Override
    public Dish findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select  e from Dish e  where  e.name like :name");
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }

    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Recipes").executeUpdate();
        sessionFactory.getCurrentSession().createQuery("delete from Dish").executeUpdate();
    }
}
