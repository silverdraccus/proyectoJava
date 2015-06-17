/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.dao.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.EspecialidadDAO;
import mx.unam.citas_medicas.modelo.Especialidad;
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
public class EspecialidadDAOImpl implements EspecialidadDAO{
    private static final Logger log = LoggerFactory.getLogger(EspecialidadDAO.class);
     private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }


    
    @Override
    public void save(Especialidad transientInstance) {
        Session session = sessionFactory.openSession();
        log.debug("saving Especialidad instance");
        try {
            session.save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    @Override
    public void delete(Especialidad persistentInstance) {
        Session session = sessionFactory.openSession();
        log.debug("deleting Especialidad instance");
        try {
            session.delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    @Override
    public Especialidad findById( java.lang.String id) {
        Session session = sessionFactory.openSession();
        log.debug("getting Especialidad instance with id: " + id);
        try {
            Especialidad instance = (Especialidad) session
                    .get("Especialidad", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @Override
    public List findByExample(Especialidad instance) {
        Session session = sessionFactory.openSession();
        log.debug("finding Especialidad instance by example");
        try {
            List results = session
                    .createCriteria(Especialidad.class)
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
        Session session = sessionFactory.openSession();
        log.debug("finding Especialidad instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Especialidad as model where model." 
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
        Session session = sessionFactory.openSession();
        log.debug("finding all Especialidad instances");
        try {
                String queryString = "from Especialidad";
         Query queryObject = session.createQuery(queryString);
                 return queryObject.list();
        } catch (RuntimeException re) {
                log.error("find all failed", re);
                throw re;
        }
    }
	
    @Override
    public Especialidad merge(Especialidad detachedInstance) {
        Session session = sessionFactory.openSession();
        log.debug("merging Especialidad instance");
        try {
            Especialidad result = (Especialidad) session
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    @Override
    public void attachDirty(Especialidad instance) {
        Session session = sessionFactory.openSession();
        log.debug("attaching dirty Especialidad instance");
        try {
            session.saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    @Override
    public void attachClean(Especialidad instance) {
        Session session = sessionFactory.openSession();
        log.debug("attaching clean Especialidad instance");
        try {
            session.buildLockRequest(LockOptions.NONE).lock(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
