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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ariadna
 */
@Repository
public class TurnoDAOImpl implements TurnoDAO{
    private static final Logger log = LoggerFactory.getLogger(TurnoDAO.class);
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    @Transactional
    public void save(Turno transientInstance) {
        Session session = sessionFactory.openSession();
        log.debug("saving Turno instance");
        try {
            session.save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
        session.disconnect();
    }
    
    @Override
    @Transactional
    public void delete(Turno persistentInstance) {
        Session session = sessionFactory.openSession();
        log.debug("deleting Turno instance");
        try {
            session.delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
        session.disconnect();
    }
    
    @Override
    @Transactional
    public Turno findById( java.lang.String id) {
        try {
            Session session = sessionFactory.openSession();
            log.debug("getting Turno instance with id: " + id);
            Turno instance = (Turno) session
                    .get("Turno", id);
            session.disconnect();
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @Override
    @Transactional
    public List findByExample(Turno instance) {
        try {
            Session session = sessionFactory.openSession();
            log.debug("finding Turno instance by example");
            List results = session
                    .createCriteria(Turno.class)
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
        log.debug("finding Turno instance with property: " + propertyName
            + ", value: " + value);
        try {
            Session session = sessionFactory.openSession();          
            String queryString = "from Turno as model where model." 
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
    @Transactional
    public List findAll() {
        log.debug("finding all Turno instances");
        try {
            Session session = sessionFactory.openSession();
            String queryString = "from Turno";
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
    public Turno merge(Turno detachedInstance) {
        
        log.debug("merging Turno instance");
        try {
            Session session = sessionFactory.openSession();
            Turno result = (Turno) session
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
    public void attachDirty(Turno instance) {
        Session session = sessionFactory.openSession();
        log.debug("attaching dirty Turno instance");
        try {
            session.saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
        session.disconnect();
    }
    
    @Override
    @Transactional
    public void attachClean(Turno instance) {
        Session session = sessionFactory.openSession();
        log.debug("attaching clean Turno instance");
        try {
            session.buildLockRequest(LockOptions.NONE).lock(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
        session.disconnect();
    }
}
