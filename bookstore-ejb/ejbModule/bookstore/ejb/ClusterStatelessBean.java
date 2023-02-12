package bookstore.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import bookstore.model.Cluster;
import bookstore.repository.ClusterRepository;

/**
 * Session Bean implementation class ClusterStatelessBean
 */
@Stateless
public class ClusterStatelessBean implements ClusterStatelessBeanRemote, ClusterStatelessBeanLocal {

	private static final Logger LOGGER = Logger.getLogger(ClusterStatelessBean.class);

	@PersistenceContext(unitName="bookstore")
	private EntityManager entityManager;

	private ClusterRepository clusterRepository;

	
    /**
     * Default constructor. 
     */
    public ClusterStatelessBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Cluster createCluster(Cluster cluster) {

		clusterRepository = new ClusterRepository(entityManager);
		LOGGER.info("Cluster: " + cluster);
		Cluster savedCluster = clusterRepository.create(cluster);
		if (savedCluster != null) {
			//LOGGER.info("ClusterCentroid creation successful" );
			return savedCluster;
		} else {
			//LOGGER.info("ClusterCentroid creation failed" );
			return null;
		}
		
	}

	@Override
	public void deleteAll() {

		clusterRepository = new ClusterRepository(entityManager);
		clusterRepository.truncate();
		LOGGER.debug("All clusterCentroids deleted" );
	}

	@Override
	public void deleteByBookId(int bookId) {
		clusterRepository = new ClusterRepository(entityManager);
		try {
			Cluster centroidToDelete = clusterRepository.findByBookId(bookId);
			if (centroidToDelete!=null) {
				clusterRepository.delete(centroidToDelete);
			}
		} catch (Exception ex) {
			LOGGER.error("deleteByBookId() : Exception : "+ex.getMessage());
		}
		LOGGER.debug("ClusterCentroid deleted" );
	}
	
	@Override
	public Cluster findByBookId(int bookId) {
		clusterRepository = new ClusterRepository(entityManager);
		LOGGER.info("Book Id: " + bookId);
		Cluster fetchedCluster = clusterRepository.findByBookId(bookId);
		if (fetchedCluster != null) {
			LOGGER.info("ClusterCentroid retrieval successful" );
			return fetchedCluster;
		} else {
			LOGGER.info("ClusterCentroid retrieval failed" );
			return null;
		}
	}

	@Override
	public List<Cluster> findByClusterNo(int clusterNo) {
		clusterRepository = new ClusterRepository(entityManager);
		LOGGER.info("Cluster No: " + clusterNo);
		List<Cluster> clusterList = clusterRepository.findByClustorNo(clusterNo);
		
		if (clusterList != null && !clusterList.isEmpty()) {
			LOGGER.info("ClusterCentroid retrieved : "+clusterList.size());
			return clusterList;
		} else {
			LOGGER.info("ClusterCentroid retrieval failed" );
			return null;
		}

	}


	@Override
	public List<Cluster> findAll() {
		clusterRepository = new ClusterRepository(entityManager);
		List<Cluster> clusterList = clusterRepository.findAll();
		
		if (clusterList != null && !clusterList.isEmpty()) {
			LOGGER.info("ClusterCentroid retrieved : "+clusterList.size());
			return clusterList;
		} else {
			LOGGER.info("ClusterCentroid retrieval failed" );
			return null;
		}
	}
	
	@Override
	public List<Cluster>  findAllByBookId(int bookId) {
		clusterRepository = new ClusterRepository(entityManager);
		List<Cluster> clusterList = clusterRepository.findAllByBookId(bookId);
		
		if (clusterList != null && !clusterList.isEmpty()) {
			LOGGER.info("ClusterCentroid retrieved : "+clusterList.size());
			return clusterList;
		} else {
			LOGGER.info("ClusterCentroid retrieval failed" );
			return null;
		}
	}

}
