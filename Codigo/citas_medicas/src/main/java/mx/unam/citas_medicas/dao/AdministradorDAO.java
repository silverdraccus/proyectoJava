/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.dao;

/**
 *
 * @author Ariadna
 */
public interface AdministradorDAO {
         private static final Logger log = LoggerFactory.getLogger(AdministradorDAO.class);
		//property constants
	public static final String NOMBRE = "nombre";



    
    public void save(Administrador transientInstance) {
        log.debug("saving Administrador instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Administrador persistentInstance) {
        log.debug("deleting Administrador instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Administrador findById( java.lang.String id) {
        log.debug("getting Administrador instance with id: " + id);
        try {
            Administrador instance = (Administrador) getSession()
                    .get("Administrador", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Administrador instance) {
        log.debug("finding Administrador instance by example");
        try {
            List results = getSession()
                    .createCriteria("Administrador")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Administrador instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Administrador as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

public List findByNombre(Object nombre);

public List findAll();
	
    public Administrador merge(Administrador detachedInstance);
    public void attachDirty(Administrador instance);
    
    public void attachClean(Administrador instance);
}
