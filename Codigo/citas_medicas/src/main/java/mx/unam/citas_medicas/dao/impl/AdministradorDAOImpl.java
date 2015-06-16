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

/**
 *
 * @author Ariadna
 */
public class AdministradorDAOImpl implements AdministradorDAO{
    private static final Logger log = LoggerFactory.getLogger(AdministradorDAOImpl.class);
    private SessionFactory sessionFactory;
    public static final String NOMBRE = "nombre";

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void save(Administrador transientInstance) {
        Session session = this.sessionFactory.getCurrentSession();
        log.debug("saving Administrador instance");
        try {
            session.save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    @Override
	public void delete(Administrador persistentInstance) {
        Session session = this.sessionFactory.getCurrentSession();
        log.debug("deleting Administrador instance");
        try {
            session.delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    @Override
    public Administrador findById( java.lang.String id) {
        Session session = this.sessionFactory.getCurrentSession();
        log.debug("getting Administrador instance with id: " + id);
        try {
            Administrador instance = (Administrador) session
                    .get("Administrador", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @Override
    public List findByExample(Administrador instance) {
        Session session = this.sessionFactory.getCurrentSession();
        log.debug("finding Administrador instance by example");
        try {
            List results = session
                    .createCriteria(Administrador.class)
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
        Session session = this.sessionFactory.getCurrentSession();
        log.debug("finding Administrador instance with property: " + propertyName
              + ", value: " + value);
        try {
            String queryString = "from Administrador as model where model." 
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
    public List findByNombre(Object nombre) {
        Session session = this.sessionFactory.getCurrentSession();
            return findByProperty(NOMBRE, nombre
            );
    }
	
    @Override
    public List findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        log.debug("finding all Administrador instances");
        try {
                String queryString = "from Administrador";
         Query queryObject = session.createQuery(queryString);
                 return queryObject.list();
        } catch (RuntimeException re) {
                log.error("find all failed", re);
                throw re;
        }
    }
	
    @Override
    public Administrador merge(Administrador detachedInstance) {
        Session session = this.sessionFactory.getCurrentSession();
        log.debug("merging Administrador instance");
        try {
            Administrador result = (Administrador) session
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    @Override
    public void attachDirty(Administrador instance) {
        Session session = this.sessionFactory.getCurrentSession();
        log.debug("attaching dirty Administrador instance");
        try {
            session.saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    @Override
    public void attachClean(Administrador instance) {
        Session session = this.sessionFactory.getCurrentSession();
        log.debug("attaching clean Administrador instance");
        try {
            session.buildLockRequest(LockOptions.NONE).lock(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
