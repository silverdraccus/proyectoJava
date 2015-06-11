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
/**
 *
 * @author Ariadna
 */
@Repository
public class UsuarioDAOImpl implements UsuarioDAO{
    private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImpl.class);
    private SessionFactory sessionFactory;
    public static final String NOMBRE = "nombre";
    public static final String PASSWORD = "password";
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void save(Usuario transientInstance) {
        Session session = this.sessionFactory.getCurrentSession();
        logger.debug("saving Usuario instance");
        try {
            session.save(transientInstance);
            logger.debug("save successful");
        } catch (RuntimeException re) {
            logger.error("save failed", re);
            throw re;
        }
    }
    
    @Override
    public void delete(Usuario persistentInstance) {
        Session session = this.sessionFactory.getCurrentSession();
        logger.debug("deleting Usuario instance");
        try {
            session.delete(persistentInstance);
            logger.debug("delete successful");
        } catch (RuntimeException re) {
            logger.error("delete failed", re);
            throw re;
        }
    }
  
    @Override
    public Usuario findById( java.lang.Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        logger.debug("getting Usuario instance with id: " + id);
        try {
            Usuario instance = (Usuario)session.get("Usuario", id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("get failed", re);
            throw re;
        }
    }
    
    @Override
    public List findByExample(Usuario instance) {
        Session session = this.sessionFactory.getCurrentSession();
        logger.debug("finding Usuario instance by example");
        try {
            List results = session .createCriteria("Usuario")
                    .add(Example.create(instance))
                    .list();
            logger.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            logger.error("find by example failed", re);
            throw re;
        }
    }    
    
    @Override
    public List findByProperty(String propertyName, Object value) {
        Session session = this.sessionFactory.getCurrentSession();
        logger.debug("finding Usuario instance with property: " + propertyName+ ", value: " + value);
        try {
            String queryString = "from Usuario as model where model."+ propertyName + "= ?";
            Query queryObject = session.createQuery(queryString);
            queryObject.setParameter(0, value);
            return queryObject.list();
        } catch (RuntimeException re) {
         logger.error("find by property name failed", re);
         throw re;
        }
    }
    
    @Override
    public List findByNombre(Object nombre) {
        Session session = this.sessionFactory.getCurrentSession();
        return findByProperty(NOMBRE, nombre );
    }
	
    @Override
    public List findByPassword(Object password) {
        Session session = this.sessionFactory.getCurrentSession();
        return findByProperty(PASSWORD, password);
    }
	
    @Override
    public List findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        logger.debug("finding all Usuario instances");
        try {
            String queryString = "from Usuario";
            Query queryObject = session.createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            logger.error("find all failed", re);
            throw re;
        }
    }
	
    @Override
    public Usuario merge(Usuario detachedInstance) {
        Session session = this.sessionFactory.getCurrentSession();
        logger.debug("merging Usuario instance");
        try {
            Usuario result = (Usuario) session.merge(detachedInstance);
            logger.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            logger.error("merge failed", re);
            throw re;
        }
    }

    @Override
    public void attachDirty(Usuario instance) {
        Session session = this.sessionFactory.getCurrentSession();
        logger.debug("attaching dirty Usuario instance");
        try {
            session.saveOrUpdate(instance);
            logger.debug("attach successful");
        } catch (RuntimeException re) {
            logger.error("attach failed", re);
            throw re;
        }
    }
    
    @Override
    public void attachClean(Usuario instance) {
        Session session = this.sessionFactory.getCurrentSession();
        logger.debug("attaching clean Usuario instance");
        try {
            session.buildLockRequest(LockOptions.NONE).lock(instance);
            logger.debug("attach successful");
        } catch (RuntimeException re) {
            logger.error("attach failed", re);
            throw re;
        }
    }
}
