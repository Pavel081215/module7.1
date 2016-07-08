package com.hibernate.base.dao.hibernate;

import com.hibernate.base.dao.OrderNameDao;
import com.hibernate.base.model.Employee;
import com.hibernate.base.model.OrderName;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pavel on 08.07.2016.
 */
public class HOrderNameDao implements OrderNameDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void save(OrderName orderName) {
        sessionFactory.getCurrentSession().save(orderName);
    }
    @Transactional
    @Override
    public Employee load(Long id) {
        return null;
    }

    @Transactional
    @Override
    public List<OrderName> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from OrderName e").list() ;
    }
    @Transactional
    @Override
    public void remove(OrderName orderName) {
        sessionFactory.getCurrentSession().delete(orderName);
    }
}
