package mx.unam.citas_medicas.dao.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.CitaDAO;
import mx.unam.citas_medicas.modelo.Cita;
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
public class CitaDAOImpl implements CitaDAO{
    private static final Logger log = LoggerFactory.getLogger(UsuarioDAOImpl.class);
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    @Override
     public void save(Cita transientInstance) {
        Session session = sessionFactory.openSession();
        log.debug("saving Cita instance");
        try {
            session.save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    @Override
    public void delete(Cita persistentInstance) {
        Session session = sessionFactory.openSession();
        log.debug("deleting Cita instance");
        try {
            session.delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    @Override
    public Cita findById( java.lang.Integer id) {
        Session session = sessionFactory.openSession();
        log.debug("getting Cita instance with id: " + id);
        try {
            Cita instance = (Cita) session
                    .get("Cita", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @Override
    public List findByExample(Cita instance) {
        Session session = sessionFactory.openSession();
        log.debug("finding Cita instance by example");
        try {
            List results = session
                    .createCriteria(Cita.class)
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
        log.debug("finding Cita instance with property: " + propertyName
              + ", value: " + value);
        try {
           String queryString = "from Cita as model where model." 
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
        log.debug("finding all Cita instances");
        try {
                String queryString = "from Cita";
         Query queryObject = session.createQuery(queryString);
                 return queryObject.list();
        } catch (RuntimeException re) {
                log.error("find all failed", re);
                throw re;
        }
    }
	
    @Override
    public Cita merge(Cita detachedInstance) {
        Session session = sessionFactory.openSession();
        log.debug("merging Cita instance");
        try {
            Cita result = (Cita) session
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    @Override
    public void attachDirty(Cita instance) {
        Session session = sessionFactory.openSession();
        log.debug("attaching dirty Cita instance");
        try {
            session.saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    @Override
    public void attachClean(Cita instance) {
        Session session = sessionFactory.openSession();
        log.debug("attaching clean Cita instance");
        try {
            session.buildLockRequest(LockOptions.NONE).lock(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
