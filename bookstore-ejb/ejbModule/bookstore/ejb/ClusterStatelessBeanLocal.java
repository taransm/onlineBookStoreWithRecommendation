package bookstore.ejb;

import java.util.List;

import javax.ejb.Local;

import bookstore.model.Cluster;

@Local
public interface ClusterStatelessBeanLocal {

	Cluster createCluster(Cluster cluster);
	
	void deleteAll();
	
	Cluster findByBookId(int bookId);

	List<Cluster> findByClusterNo(int clusterNo);

	List<Cluster> findAll();

	List<Cluster> findAllByBookId(int bookId);
	
	void deleteByBookId(int bookId);
}
