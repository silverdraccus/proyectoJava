
package mx.unam.citas_medicas.dao.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.PacienteDAO;
import mx.unam.citas_medicas.modelo.Paciente;
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
public class PacienteDAOImpl implements PacienteDAO{
    private static final Logger log = LoggerFactory.getLogger(PacienteDAO.class);
    //property constants
    public static final String NOMBRE = "nombre";
    public static final String CARRERA = "carrera";
    public static final String SEMESTRE_VIGENTE = "semestreVigente";
    public static final String DIR_CALLE = "dirCalle";
    public static final String DIR_NUMERO = "dirNumero";
    public static final String DIR_COLONIA = "dirColonia";
    public static final String TELEFONO = "telefono";
    public static final String CORREO_E = "correoE";

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    @Override
    public void save(Paciente transientInstance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("saving Paciente instance");
        try {
            session.save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    public void delete(Paciente persistentInstance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("deleting Paciente instance");
        try {
            session.delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    @Override
    public Paciente findById( java.lang.Integer id) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("getting Paciente instance with id: " + id);
        try {
            Paciente instance = (Paciente) session
                    .get("Paciente", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @Override
    public List findByExample(Paciente instance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("finding Paciente instance by example");
        try {
            List results = session
                    .createCriteria(Paciente.class)
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
        log.debug("finding Paciente instance with property: " + propertyName
              + ", value: " + value);
        try {
            String queryString = "from Paciente as model where model." 
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
        return findByProperty(NOMBRE, nombre);
    }
	
    @Override
    public List findByCarrera(Object carrera) {
        return findByProperty(CARRERA, carrera);
    }
	
    @Override
    public List findBySemestreVigente(Object semestreVigente) {
            return findByProperty(SEMESTRE_VIGENTE, semestreVigente);
    }

    @Override
    public List findByDirCalle(Object dirCalle) {
        return findByProperty(DIR_CALLE, dirCalle);
    }

    @Override
    public List findByDirNumero(Object dirNumero) {
        return findByProperty(DIR_NUMERO, dirNumero);
    }

    @Override
    public List findByDirColonia(Object dirColonia) {
        return findByProperty(DIR_COLONIA, dirColonia);
    }

    @Override
    public List findByTelefono(Object telefono) {
        return findByProperty(TELEFONO, telefono);
    }

    @Override
    public List findByCorreoE(Object correoE) {
        return findByProperty(CORREO_E, correoE);
    }


    @Override
    public List findAll() {
        Session session=sessionFactory.getCurrentSession();
        log.debug("finding all Paciente instances");
        try {
                String queryString = "from Paciente";
         Query queryObject = session.createQuery(queryString);
                 return queryObject.list();
        } catch (RuntimeException re) {
                log.error("find all failed", re);
                throw re;
        }
    }
	
    @Override
    public Paciente merge(Paciente detachedInstance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("merging Paciente instance");
        try {
            Paciente result = (Paciente) session
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    @Override
    public void attachDirty(Paciente instance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("attaching dirty Paciente instance");
        try {
            session.saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    @Override
    public void attachClean(Paciente instance) {
        Session session=sessionFactory.getCurrentSession();
        log.debug("attaching clean Paciente instance");
        try {
            session.buildLockRequest(LockOptions.NONE).lock(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
