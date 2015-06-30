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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ariadna
 */
@Repository
public class EspecialidadDAOImpl implements EspecialidadDAO{
    private static final Logger log = LoggerFactory.getLogger(EspecialidadDAO.class);
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }


    
    @Override
    @Transactional
    public void save(Especialidad transientInstance) {
        log.debug("saving Especialidad instance");
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
    public void delete(Especialidad persistentInstance) {
        log.debug("deleting Especialidad instance");
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
    public Especialidad findById( java.lang.String id) {
        log.debug("getting Especialidad instance with id: " + id);
        try {
            Session session = sessionFactory.openSession();
            Especialidad instance = (Especialidad) session
                    .get("Especialidad", id);
            session.disconnect();
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @Override
    @Transactional
    public List findByExample(Especialidad instance) {
        log.debug("finding Especialidad instance by example");
        try {
            Session session = sessionFactory.openSession();
            List results = session
                    .createCriteria(Especialidad.class)
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
        log.debug("finding Especialidad instance with property: " + propertyName
                + ", value: " + value);
        try {
            Session session = sessionFactory.openSession();
            String queryString = "from Especialidad as model where model." 
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

    @Transactional
    @Override
    public List findAll() {
        log.debug("finding all Especialidad instances");
        try {
            Session session = sessionFactory.openSession();
            String queryString = "from Especialidad";
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
    public Especialidad merge(Especialidad detachedInstance) {
        log.debug("merging Especialidad instance");
        try {
            Session session = sessionFactory.openSession();
            Especialidad result = (Especialidad) session
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
    public void attachDirty(Especialidad instance) {
        log.debug("attaching dirty Especialidad instance");
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
    public void attachClean(Especialidad instance) {
        log.debug("attaching clean Especialidad instance");
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
