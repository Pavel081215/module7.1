package com.hibernate.base.dao.hibernate;

import com.hibernate.base.dao.StockDao;
import com.hibernate.base.model.Employee;
import com.hibernate.base.model.Stock;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class HStockDao implements StockDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void save(Stock stock) {
        sessionFactory.getCurrentSession().save(stock);
    }
    @Transactional
    @Override
    public Employee load(Long id) {
        return null;
    }
    @Transactional
    @Override
    public List<Stock> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from Stoke e").list() ;
    }
    @Transactional
    @Override
    public void remove(Stock stock) {
        sessionFactory.getCurrentSession().delete(stock);
    }
    @Transactional
    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Stoke").executeUpdate() ;
    }

    @Override
    public Stock findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select  e from Stone e  where  e.name like :name");
        query.setParameter("name", name);
        return (Stock) query.uniqueResult();
    }
}
