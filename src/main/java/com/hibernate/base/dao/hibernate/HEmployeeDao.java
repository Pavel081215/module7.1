package com.hibernate.base.dao.hibernate;

import com.hibernate.base.dao.EmployeeDao;
import com.hibernate.base.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pavel on 08.07.2016.
 */
public class HEmployeeDao implements EmployeeDao {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Transactional
    @Override
    public Employee load(Long id) {
        return null;
    }

    @Transactional
    @Override
    public List<Employee> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from Employee e").list();
    }

    @Transactional
    @Override
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Transactional
    @Override
    public Employee findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select  e from Employee e  where  e.name like :name");
        query.setParameter("name", name);
        return (Employee) query.uniqueResult();
    }
}
