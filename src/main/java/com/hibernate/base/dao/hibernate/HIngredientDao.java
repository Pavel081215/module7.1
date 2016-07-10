package com.hibernate.base.dao.hibernate;

import com.hibernate.base.dao.IngredientDao;
import com.hibernate.base.model.Employee;
import com.hibernate.base.model.Ingredient;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class HIngredientDao implements IngredientDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void save(Ingredient ingredient) {
        sessionFactory.getCurrentSession().save(ingredient);
    }

    @Transactional
    @Override
    public Employee load(Long id) {
        return null;
    }

    @Transactional
    @Override
    public List<Ingredient> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from Ingredient e").list();
    }

    @Transactional
    @Override
    public void remove(Ingredient ingredient) {
        sessionFactory.getCurrentSession().delete(ingredient);
    }

    @Transactional
    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Ingredient").executeUpdate();
    }

    @Override
    public Ingredient findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select  e from Ingredient e  where  e.name like :name");
        query.setParameter("name", name);
        return (Ingredient) query.uniqueResult();
    }
}
