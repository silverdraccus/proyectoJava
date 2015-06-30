package mx.unam.citas_medicas.dao.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.ConsultorioDAO;
import mx.unam.citas_medicas.modelo.Consultorio;
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
public class ConsultorioDAOImpl implements ConsultorioDAO{
    private static final Logger log = LoggerFactory.getLogger(ConsultorioDAO.class);
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    
    @Override
    @Transactional
    public void save(Consultorio transientInstance) {
        log.debug("saving Consultorio instance");
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
    public void delete(Consultorio persistentInstance) {
        log.debug("deleting Consultorio instance");
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
    public Consultorio findById( java.lang.Integer id) {
        log.debug("getting Consultorio instance with id: " + id);
        try {
            Session session = sessionFactory.openSession();
            Consultorio instance = (Consultorio) session
                    .get("Consultorio", id);
            session.disconnect();
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @Override
    @Transactional
    public List findByExample(Consultorio instance) {
        log.debug("finding Consultorio instance by example");
        try {
            Session session = sessionFactory.openSession();
            List results = session
                    .createCriteria(Consultorio.class)
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
        log.debug("finding Consultorio instance with property: " + propertyName
            + ", value: " + value);
        try {
            Session session = sessionFactory.openSession();
            String queryString = "from Consultorio as model where model." 
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
        log.debug("finding all Consultorio instances");
        try {
            Session session = sessionFactory.openSession();
            String queryString = "from Consultorio";
            Query queryObject = session.createQuery(queryString);
            session.disconnect();
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }
	
    @Override
    public Consultorio merge(Consultorio detachedInstance) {
        log.debug("merging Consultorio instance");
        try {
            Session session = sessionFactory.openSession();
            Consultorio result = (Consultorio) session
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
    public void attachDirty(Consultorio instance) {
        log.debug("attaching dirty Consultorio instance");
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
    public void attachClean(Consultorio instance) {
        log.debug("attaching clean Consultorio instance");
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
