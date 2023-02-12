package bookstore.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import bookstore.model.Cluster;

public class ClusterRepository {

	private static final Logger LOGGER = Logger.getLogger(ClusterRepository.class);

    private EntityManager entityManager;
    
    public ClusterRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Transactional
    public Cluster create(Cluster cluster) {
    	LOGGER.info("ClusterRepository.Create()" );
    	try {
	    	//entityManager.getTransaction().begin();
	        entityManager.persist(cluster);
	        //entityManager.getTransaction().commit();
	        return cluster;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
    }
    
    @Transactional
    public void delete(Cluster cluster) {
    	LOGGER.info("ClusterRepository.Delete()" );
        try {
            entityManager.remove(cluster);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
	public List<Cluster> findAll() {
    	LOGGER.info("ClusterRepository.FindAll()" );
        return entityManager
        		.createQuery("from Cluster")
        		.getResultList();
    }
    
    public Cluster findByBookId(int bookId) {
    	LOGGER.info("ClusterRepository.FindByBookId() : "+bookId );
    	
        Cluster cluster = entityManager
        		.createNamedQuery("Cluster.findByBookId", Cluster.class)
                .setParameter("bookId", bookId)
                .getSingleResult();
        
        if (cluster != null) {
        	return cluster;
        }
    	return null;
    }
    
    public List<Cluster> findByClustorNo(int clusterNo) {
    	LOGGER.info("ClusterRepository.FindByClusterNo() : "+clusterNo);
        List<Cluster> clusters = entityManager
        		.createNamedQuery("Cluster.findByClustorNo", Cluster.class)
                .setParameter("clusterNo", clusterNo)
                .getResultList();

        if (clusters!=null && !clusters.isEmpty()) {
        	return clusters;
        }
    	return null;
    }

    @Transactional
    public void truncate() {
    	LOGGER.info("ClusterRepository.Truncate()");
        entityManager
    		.createNativeQuery("truncate table Cluster")
            .executeUpdate();
    }
    
    public List<Cluster> findAllByBookId(int bookId) {
    	LOGGER.info("BookRepository.findAllByBookId() :"+bookId );

    	Cluster cluster = findByBookId(bookId);
       	LOGGER.info("BookRepository.findAllByBookId() :"+cluster);
   	
       	if (cluster == null) {
       		return null;
       	}

    	List<Cluster> clusters = entityManager
        		.createQuery("select c from Cluster c where c.clusterNo = :clusterNo and c.bookId != :bookId",  Cluster.class)
        		.setParameter("clusterNo", cluster.getClusterNo())
        		.setParameter("bookId", cluster.getBookId())
        		.getResultList();

    	if (clusters!=null && !clusters.isEmpty()) {
        	return clusters;
        }
    	return null;
    }
    
}