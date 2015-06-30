package mx.unam.citas_medicas.dao.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.*;
import mx.unam.citas_medicas.modelo.Administrador;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ariadna
 */
@Repository
public class AdministradorDAOImpl implements AdministradorDAO{
    private static final Logger log = LoggerFactory.getLogger(AdministradorDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    public static final String NOMBRE = "nombre";

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    @Transactional
    public void save(Administrador transientInstance) {
        log.debug("saving Administrador instance");
        try {
            Session session = sessionFactory.openSession();
            session.save(transientInstance);
            log.debug("save successful");
            session.disconnect();
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    @Override
    @Transactional
	public void delete(Administrador persistentInstance) {
        log.debug("deleting Administrador instance");
        try {
            Session session = sessionFactory.openSession();
            session.delete(persistentInstance);
            log.debug("delete successful");
            session.disconnect();
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    @Override
    @Transactional
    public Administrador findById( java.lang.String id) {
        log.debug("getting Administrador instance with id: " + id);
        try {
            Session session = sessionFactory.openSession();
            Administrador instance = (Administrador) session
                    .get("Administrador", id);
            session.disconnect();
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @Override
    @Transactional
    public List findByExample(Administrador instance) {
        log.debug("finding Administrador instance by example");
        try {
            Session session = sessionFactory.openSession();
            List results = session
                    .createCriteria(Administrador.class)
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            session.disconnect();
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @Override
    @Transactional
    public List findByProperty(String propertyName, Object value) {
        log.debug("finding Administrador instance with property: " + propertyName
              + ", value: " + value);
        try {
            Session session = sessionFactory.openSession();
            String queryString = "from Administrador as model where model." 
                                                          + propertyName + "= ?";
            Query queryObject = session.createQuery(queryString);
                   queryObject.setParameter(0, value);
            session.disconnect();
            return queryObject.list();
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
    }

    @Override
    public List findByNombre(Object nombre) {
        return findByProperty(NOMBRE, nombre);
    }
	
    @Override
    @Transactional
    public List findAll() {
        log.debug("finding all Administrador instances");
        try {
            Session session = sessionFactory.openSession();
            String queryString = "from Administrador";
            Query queryObject = session.createQuery(queryString);
            session.disconnect();
            return queryObject.list();
        } catch (RuntimeException re) {
                log.error("find all failed", re);
                throw re;
        }
    }
	
    @Override
    @Transactional
    public Administrador merge(Administrador detachedInstance) {
        log.debug("merging Administrador instance");
        try {
            Session session = sessionFactory.openSession();
            Administrador result = (Administrador) session
                    .merge(detachedInstance);
            log.debug("merge successful");
            session.disconnect();
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    @Override
    @Transactional
    public void attachDirty(Administrador instance) {
        log.debug("attaching dirty Administrador instance");
        try {
            Session session = sessionFactory.openSession();
            session.saveOrUpdate(instance);
            log.debug("attach successful");
            session.disconnect();
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    @Override
    @Transactional
    public void attachClean(Administrador instance) {
        log.debug("attaching clean Administrador instance");
        try {
            Session session = sessionFactory.openSession();
            session.buildLockRequest(LockOptions.NONE).lock(instance);
            log.debug("attach successful");
            session.disconnect();
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
