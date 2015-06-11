/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.dao.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.TurnoDAO;
import mx.unam.citas_medicas.modelo.Turno;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ariadna
 */
public class TurnoDAOImpl implements TurnoDAO{
    private static final Logger log = LoggerFactory.getLogger(TurnoDAO.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void save(Turno transientInstance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("saving Turno instance");
        try {
            session.save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    @Override
    public void delete(Turno persistentInstance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("deleting Turno instance");
        try {
            session.delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    @Override
    public Turno findById( java.lang.String id) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("getting Turno instance with id: " + id);
        try {
            Turno instance = (Turno) session
                    .get("Turno", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @Override
    public List findByExample(Turno instance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("finding Turno instance by example");
        try {
            List results = session
                    .createCriteria("Turno")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @Override
    public List findByProperty(String propertyName, Object value) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("finding Turno instance with property: " + propertyName
            + ", value: " + value);
        try {
            String queryString = "from Turno as model where model." 
                                                          + propertyName + "= ?";
            Query queryObject = session.createQuery(queryString);
                   queryObject.setParameter(0, value);
                   return queryObject.list();
        } catch (RuntimeException re) {
             log.error("find by property name failed", re);
            throw re;
        }
    }


    @Override
    public List findAll() {
        Session session=sessionFactory.getCurrentSession();
        log.debug("finding all Turno instances");
        try {
                String queryString = "from Turno";
         Query queryObject = session.createQuery(queryString);
                 return queryObject.list();
        } catch (RuntimeException re) {
                log.error("find all failed", re);
                throw re;
        }
    }
	
    @Override
    public Turno merge(Turno detachedInstance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("merging Turno instance");
        try {
            Turno result = (Turno) session
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    @Override
    public void attachDirty(Turno instance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("attaching dirty Turno instance");
        try {
            session.saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    @Override
    public void attachClean(Turno instance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("attaching clean Turno instance");
        try {
            session.buildLockRequest(LockOptions.NONE).lock(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
