package com.hibernate.base.dao.hibernate;

import com.hibernate.base.dao.EmployeeDao;
import com.hibernate.base.model.Employee;
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
        return null;
    }
}
