package mx.unam.citas_medicas.dao.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.UsuarioDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import mx.unam.citas_medicas.modelo.Usuario;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Ariadna
 */
@Repository
public class UsuarioDAOImpl implements UsuarioDAO{
    private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    
    public static final String NOMBRE = "nombre";
    public static final String PASSWORD = "password";
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Transactional
    @Override
    public void save(Usuario transientInstance) {
       Session session = sessionFactory.openSession();
        logger.debug("saving Usuario instance");
        try {
            session.save(transientInstance);
            logger.debug("save successful");
        } catch (RuntimeException re) {
            logger.error("save failed", re);
            throw re;
        }
        session.disconnect();
    }
    
    @Transactional
    @Override
    public void delete(Usuario persistentInstance) {
       Session session = sessionFactory.openSession();
        logger.debug("deleting Usuario instance");
        try {
            session.delete(persistentInstance);
            logger.debug("delete successful");
        } catch (RuntimeException re) {
            logger.error("delete failed", re);
            throw re;
        }
        session.disconnect();
    }
    
    @Transactional
    @Override
    public Usuario findById( java.lang.Integer id) {  
        logger.debug("getting Usuario instance with id: " + id);
        try {
            Session session = sessionFactory.openSession();
            Usuario instance = (Usuario)session.get("Usuario", id);
            session.disconnect();
            return instance;
        } catch (RuntimeException re) {
            logger.error("get failed", re);
            throw re;
        }
    }
    
    @Transactional
    @Override
    public List findByExample(Usuario instance) { 
        logger.debug("finding Usuario instance by example");
        try {
           Session session = sessionFactory.openSession();
            Transaction trans=session.beginTransaction();
            List results = session.createCriteria(Usuario.class)
                    .add(Example.create(instance))
                    .list();   
            logger.debug("find by example successful, result size: " + results.size());
            trans.commit();
            session.disconnect();
            return results;
        } catch (RuntimeException re) {
            logger.error("find by example failed", re);
            throw re;
        }
        
    }  
    
    @Transactional
    @Override
    public List findByProperty(String propertyName, Object value) {
        
        logger.debug("finding Usuario instance with property: " + propertyName+ ", value: " + value);
        try {
            Session session = sessionFactory.openSession();
            String queryString = "from Usuario as model where model."+ propertyName + "= ?";
            Query queryObject = session.createQuery(queryString);
            queryObject.setParameter(0, value);
            session.disconnect();
            return queryObject.list(); 
        } catch (RuntimeException re) {
         logger.error("find by property name failed", re);
         throw re;
        }
    }
    
    @Override
    public List findByNombre(Object nombre) {
        return findByProperty(NOMBRE, nombre );
    }
    
    @Override
    public List findByPassword(Object password) {
        return findByProperty(PASSWORD, password);
    }
    
    @Transactional
    @Override
    public List findAll() {
        logger.debug("finding all Usuario instances");
        try {
           Session session = sessionFactory.openSession();
            String queryString = "from Usuario";
            Query queryObject = session.createQuery(queryString);
            session.disconnect();
            return queryObject.list();
        } catch (RuntimeException re) {
            logger.error("find all failed", re);
            throw re;
        }
    }

    @Transactional
    @Override
    public Usuario merge(Usuario detachedInstance) {  
        logger.debug("merging Usuario instance");
        try {
            Session session = sessionFactory.openSession();
            Usuario result = (Usuario) session.merge(detachedInstance);
            session.disconnect();
            logger.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            logger.error("merge failed", re);
            throw re;
        }
    }

    @Transactional
    @Override
    public void attachDirty(Usuario instance) {
       Session session = sessionFactory.openSession();
        logger.debug("attaching dirty Usuario instance");
        try {
            Transaction trans=session.beginTransaction();
            session.saveOrUpdate(instance);
            trans.commit();
            logger.debug("attach successful");
        } catch (RuntimeException re) {
            logger.error("attach failed", re);
            throw re;
        }
        session.disconnect();
    }
    
    @Transactional
    @Override
    public void attachClean(Usuario instance) {
       Session session = sessionFactory.openSession();
        logger.debug("attaching clean Usuario instance");
        try {
            session.buildLockRequest(LockOptions.NONE).lock(instance);
            logger.debug("attach successful");
        } catch (RuntimeException re) {
            logger.error("attach failed", re);
            throw re;
        }
        session.disconnect();
    }
}
