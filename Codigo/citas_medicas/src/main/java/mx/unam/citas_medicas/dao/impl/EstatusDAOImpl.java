
package mx.unam.citas_medicas.dao.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.EstatusDAO;
import mx.unam.citas_medicas.modelo.Estatus;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ariadna
 */
@Repository
public class EstatusDAOImpl implements EstatusDAO{
    private static final Logger log = LoggerFactory.getLogger(EstatusDAO.class);
    //property constants
    public static final String DESCRIPCION = "descripcion";
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    @Override
    public void save(Estatus transientInstance) {
        Session session = sessionFactory.openSession();
        log.debug("saving Estatus instance");
        try {
            session.save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    @Override
    public void delete(Estatus persistentInstance) {
        Session session = sessionFactory.openSession();
        log.debug("deleting Estatus instance");
        try {
            session.delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    @Override
    public Estatus findById( java.lang.Integer id) {
        Session session = sessionFactory.openSession();
        log.debug("getting Estatus instance with id: " + id);
        try {
            Estatus instance = (Estatus) session
                    .get("Estatus", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    @Override
    public List findByExample(Estatus instance) {
        Session session = sessionFactory.openSession();
        log.debug("finding Estatus instance by example");
        try {
            List results = session
                    .createCriteria(Estatus.class)
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
        log.debug("finding Estatus instance with property: " + propertyName
            + ", value: " + value);
        try {
             String queryString = "from Estatus as model where model." 
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
	public List findByDescripcion(Object descripcion) {
            return findByProperty(DESCRIPCION, descripcion);
	}
	

    @Override
	public List findAll() {
            Session session = sessionFactory.openSession();
            log.debug("finding all Estatus instances");
            try {
                    String queryString = "from Estatus";
             Query queryObject = session.createQuery(queryString);
                     return queryObject.list();
            } catch (RuntimeException re) {
                    log.error("find all failed", re);
                    throw re;
            }
	}
	
    @Override
    public Estatus merge(Estatus detachedInstance) {
        Session session = sessionFactory.openSession();
        log.debug("merging Estatus instance");
        try {
            Estatus result = (Estatus) session
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    @Override
    public void attachDirty(Estatus instance) {
        Session session = sessionFactory.openSession();
        log.debug("attaching dirty Estatus instance");
        try {
            session.saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    @Override
    public void attachClean(Estatus instance) {
        Session session = sessionFactory.openSession();
        log.debug("attaching clean Estatus instance");
        try {
            session.buildLockRequest(LockOptions.NONE).lock(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
