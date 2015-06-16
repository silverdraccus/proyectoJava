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

/**
 *
 * @author Ariadna
 */
public class ConsultorioDAOImpl implements ConsultorioDAO{
    private static final Logger log = LoggerFactory.getLogger(ConsultorioDAO.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    
    @Override
    public void save(Consultorio transientInstance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("saving Consultorio instance");
        try {
            session.save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    @Override
    public void delete(Consultorio persistentInstance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("deleting Consultorio instance");
        try {
            session.delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    @Override
    public Consultorio findById( java.lang.Integer id) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("getting Consultorio instance with id: " + id);
        try {
            Consultorio instance = (Consultorio) session
                    .get("Consultorio", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @Override
    public List findByExample(Consultorio instance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("finding Consultorio instance by example");
        try {
            List results = session
                    .createCriteria(Consultorio.class)
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
        log.debug("finding Consultorio instance with property: " + propertyName
            + ", value: " + value);
        try {
            String queryString = "from Consultorio as model where model." 
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
            log.debug("finding all Consultorio instances");
            try {
                    String queryString = "from Consultorio";
             Query queryObject = session.createQuery(queryString);
                     return queryObject.list();
            } catch (RuntimeException re) {
                    log.error("find all failed", re);
                    throw re;
            }
    }
	
    @Override
    public Consultorio merge(Consultorio detachedInstance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("merging Consultorio instance");
        try {
            Consultorio result = (Consultorio) session
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    @Override
    public void attachDirty(Consultorio instance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("attaching dirty Consultorio instance");
        try {
            session.saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    @Override
    public void attachClean(Consultorio instance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("attaching clean Consultorio instance");
        try {
            session.buildLockRequest(LockOptions.NONE).lock(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
