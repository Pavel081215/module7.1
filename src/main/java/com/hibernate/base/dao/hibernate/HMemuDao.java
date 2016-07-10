package com.hibernate.base.dao.hibernate;

import com.hibernate.base.dao.MenuDao;
import com.hibernate.base.model.Employee;
import com.hibernate.base.model.Menu;
import com.hibernate.base.model.Stock;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class HMemuDao implements MenuDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void save(Menu menu) {
        sessionFactory.getCurrentSession().save(menu);
    }
    @Transactional
    @Override
    public Employee load(Long id) {
        return null;
    }
    @Transactional
    @Override
    public List<Menu> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from Menu e").list() ;
    }
    @Transactional
    @Override
    public void remove(Menu menu) {
        sessionFactory.getCurrentSession().delete(menu);
    }
    @Transactional
    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Menu").executeUpdate() ;
    }
    @Transactional
    @Override
    public Menu findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select  e from Menu e  where  e.name like :name");
        query.setParameter("name", name);
        return (Menu) query.uniqueResult();
    }
}
