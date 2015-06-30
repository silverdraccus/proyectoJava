package mx.unam.citas_medicas.dao.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.DoctorDAO;
import mx.unam.citas_medicas.modelo.Doctor;
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
public class DoctorDAOImpl implements DoctorDAO{
    private static final Logger log = LoggerFactory.getLogger(DoctorDAO.class);
    @Autowired
    private SessionFactory sessionFactory;
    //property constants
    public static final String NOMBRE = "nombre";

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    @Override
    @Transactional
    public void save(Doctor transientInstance) {
        Session session = sessionFactory.openSession();
        log.debug("saving Doctor instance");
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
    public void delete(Doctor persistentInstance) {
        Session session = sessionFactory.openSession();
        log.debug("deleting Doctor instance");
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
    public Doctor findById(String rfc) {
        Session session = sessionFactory.openSession();
        log.debug("getting Doctor instance with id: " + rfc);
        try {
            Doctor instance = (Doctor) session.get(Doctor.class, rfc);
            session.disconnect();
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            session.disconnect();
            throw re;
        }
        
    }
    
    @Override
    @Transactional
    public List findByExample(Doctor instance) {
        Session session = sessionFactory.openSession();
        log.debug("finding Doctor instance by example");
        try {
            List results = session
                    .createCriteria(Doctor.class)
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            session.disconnect();
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            session.disconnect();
            throw re;
        }
    }    
    
    @Override
    @Transactional
    public List findByProperty(String propertyName, Object value) {
        Session session = sessionFactory.openSession();
        log.debug("finding Doctor instance with property: " + propertyName
            + ", value: " + value);
        try {
            String queryString = "from Doctor as model where model." 
                                                          + propertyName + "= ?";
            Query queryObject = session.createQuery(queryString);
                   queryObject.setParameter(0, value);
            session.disconnect();
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            session.disconnect();
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
        Session session = sessionFactory.openSession();
        log.debug("finding all Doctor instances");
        try {
            String queryString = "from Doctor";
            Query queryObject = session.createQuery(queryString);
            session.disconnect();
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            session.disconnect();
            throw re;
        }
    }
	
    @Override
    @Transactional
    public Doctor merge(Doctor detachedInstance) {
        Session session = sessionFactory.openSession();
        log.debug("merging Doctor instance");
        try {
            Doctor result = (Doctor) session
                    .merge(detachedInstance);
            log.debug("merge successful");
            session.disconnect();
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            session.disconnect();
            throw re;
        }
    }

    @Override
    @Transactional
    public void attachDirty(Doctor instance) {
        Session session = sessionFactory.openSession();
        log.debug("attaching dirty Doctor instance");
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
    public void attachClean(Doctor instance) {
        Session session = sessionFactory.openSession();
        log.debug("attaching clean Doctor instance");
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
