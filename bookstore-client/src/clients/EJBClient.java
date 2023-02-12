package clients;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import bookstore.ejb.BookStatelessBeanRemote;
import bookstore.ejb.ClusterStatelessBeanRemote;
import bookstore.ejb.RecommendationSingletonRemote;
import bookstore.ejb.UserSessionBeanRemote;
import bookstore.model.Book;
import bookstore.model.Cluster;

public class EJBClient {

	public static void main(String[] args) throws NamingException {
		
		//UserSessionBeanTest();
		
		//BookStatelessBeanTest();

		//ClusterStatelessBeanTest();
		
		RecommendationSingletonTest();
	}

	private static void RecommendationSingletonTest() throws NamingException {
		System.out.println("Checking RecommendationSingleton, please wait....");
		System.out.println();
		RecommendationSingletonRemote recommendationSingleton 
			= (RecommendationSingletonRemote) InitialContext.doLookup("bookstore-ejb/RecommendationSingleton!bookstore.ejb.RecommendationSingletonRemote");
	
		recommendationSingleton.calculateRecommendataion();
		System.out.println("Please check if recommendation is performed ?");
	}	

	private static void ClusterStatelessBeanTest() throws NamingException {
		
		System.out.println("Checking ClusterStatelessBean, please wait....");
		System.out.println();
		ClusterStatelessBeanRemote clusterStatelessBean 
			= (ClusterStatelessBeanRemote) InitialContext.doLookup("bookstore-ejb/ClusterStatelessBean!bookstore.ejb.ClusterStatelessBeanRemote");

		Cluster cluster = new Cluster();
		cluster.setClusterNo(0);
		cluster.setBookId(1000);
		
		System.out.println("Cluster 1: "+clusterStatelessBean.createCluster(cluster));
		System.out.println("Total Clusters: "+clusterStatelessBean.findAll());
		
		cluster = new Cluster();
		cluster.setClusterNo(0);
		cluster.setBookId(2000);
		
		System.out.println("Cluster 2: "+clusterStatelessBean.createCluster(cluster));
		System.out.println("Total Clusters: "+clusterStatelessBean.findAll());

		cluster = new Cluster();
		cluster.setClusterNo(1);
		cluster.setBookId(3000);
		
		System.out.println("Cluster 3: "+clusterStatelessBean.createCluster(cluster));
		System.out.println("Total Clusters: "+clusterStatelessBean.findAll());

		cluster = clusterStatelessBean.findByBookId(1000);
		System.out.println("Cluster Retrieved: "+cluster);

		System.out.println("Clusters(0) Retrieved: "+clusterStatelessBean.findByClusterNo(0).size());

		System.out.println("FindAllByBookID(1000) Clusters: "+clusterStatelessBean.findAllByBookId(1000));
		System.out.println("FindAllByBookID(2000) Clusters: "+clusterStatelessBean.findAllByBookId(2000));
		System.out.println("FindAllByBookID(3000) Clusters: "+clusterStatelessBean.findAllByBookId(3000));
		
		clusterStatelessBean.deleteAll();
		System.out.println("Clusters deleted");
		System.out.println("Total Clusters: "+clusterStatelessBean.findAll());
		
		System.out.println();
	}

	private static void BookStatelessBeanTest() throws NamingException {
		
		System.out.println("Checking BookStatelessBean, please wait....");
		System.out.println();
		BookStatelessBeanRemote bookStatelessBean 
			= (BookStatelessBeanRemote) InitialContext.doLookup("bookstore-ejb/BookStatelessBean!bookstore.ejb.BookStatelessBeanRemote");

		System.out.println(bookStatelessBean.findAll().size());

		System.out.println(bookStatelessBean.findById(2));

		Book book = new Book();
		book.setTitle("Amit");
		book.setAuthor("Amit");
		bookStatelessBean.createBook(book);
		System.out.println("Check if book created?");
		
		System.out.println();
	}
	
	private static void UserSessionBeanTest() throws NamingException {
		
		System.out.println("Checking UserSessionBean, please wait....");
		System.out.println();
		UserSessionBeanRemote userBean 
			= (UserSessionBeanRemote) InitialContext.doLookup("bookstore-ejb/UserSessionBean!bookstore.ejb.UserSessionBeanRemote");

		System.out.println(userBean.validate("admin"));

		System.out.println(userBean.authenticate("admin","cp630"));

		System.out.println();
	}
	
}
