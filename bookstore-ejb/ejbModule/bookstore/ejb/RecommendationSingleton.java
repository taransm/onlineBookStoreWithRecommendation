package bookstore.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import bookstore.model.Book;
import bookstore.model.Cluster;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

/**
 * Session Bean implementation class RecommendationSingletonBean
 */
@Singleton
public class RecommendationSingleton implements RecommendationSingletonRemote, RecommendationSingletonLocal {

	private static final Logger LOGGER = Logger.getLogger(RecommendationSingleton.class);
	
	@EJB
	ClusterStatelessBeanLocal clusterStatelessBeanLocal;

	@EJB
	BookStatelessBeanLocal bookStatelessBeanLocal;

    /**
     * Default constructor. 
     */
    public RecommendationSingleton() {
        // TODO Auto-generated constructor stub
    }

	@Override
	@Transactional
	public void calculateRecommendataion() {
		
		// TODO Get all books
		List<Book> books = bookStatelessBeanLocal.findAll();
		LOGGER.info("Books: " + books.size());

		if (books==null || books.isEmpty()) {
			return;
		}
		
		clusterStatelessBeanLocal.deleteAll();
		
		try {

			Instances dataSet = getDataSet(books);
			LOGGER.info("DataSet: " + books.size());
	
			// TODO Perform Kmean Algorithm
			SimpleKMeans kmeans = new SimpleKMeans();
			kmeans.setNumClusters(dataSet.size()/10);
			kmeans.buildClusterer(dataSet);
	
			ClusterEvaluation eval = new ClusterEvaluation();
			eval.setClusterer(kmeans);
			eval.evaluateClusterer(dataSet);
			LOGGER.info("Clustering Details:"+eval.clusterResultsToString());
	
			// TODO Store the data
			double[] clusterAssignments = eval.getClusterAssignments();
			for (int index=0; index<clusterAssignments.length; index++) {
				int clusterNo = (int)clusterAssignments[index];
				Book book = books.get(index);
				int bookId = -1;
				if (book != null) {
					bookId = book.getBookId();
				}
				clusterStatelessBeanLocal.createCluster(new Cluster(clusterNo, bookId));
			}
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	
	private Instances getDataSet(List<Book> books) {
		
//		  List<String> stringValues = null;
//        Attribute attrTitle = new Attribute("Title", stringValues);
//        Attribute attrAuthor = new Attribute("Author", stringValues);
//        Attribute attrEdition = new Attribute("Edition", stringValues);
        Attribute attrReviews = new Attribute("Reviews");
        Attribute attrRatings = new Attribute("Ratings");
        Attribute attrGenre = new Attribute("Genre");
        Attribute attrCategory = new Attribute("Category");
        Attribute attrPrice = new Attribute("Price");

		ArrayList<Attribute> listAttributes = new ArrayList<Attribute>();
//        listAttributes.add(attrTitle);
//        listAttributes.add(attrAuthor);
//        listAttributes.add(attrEdition);
        listAttributes.add(attrReviews);
        listAttributes.add(attrRatings);
        listAttributes.add(attrGenre);
        listAttributes.add(attrCategory);
        listAttributes.add(attrPrice);
		LOGGER.info("Attributes: " + listAttributes);

		Instances dataSet = new Instances("BookInfo", listAttributes, 0);
		
		for (int index=0; index<books.size(); index++) {
			
			Book book = books.get(index);
			DenseInstance instance = new DenseInstance(listAttributes.size());
//			instance.setValue(attrTitle, book.getTitle());
//			instance.setValue(attrAuthor, book.getAuthor());
//			instance.setValue(attrEdition, book.getEdition());
			instance.setValue(attrReviews, book.getReviews());
			instance.setValue(attrRatings, book.getRatings());
			instance.setValue(attrGenre, book.getGenreId());
			instance.setValue(attrCategory, book.getCategoryId());
			instance.setValue(attrPrice, book.getPrice());
			dataSet.add(instance);
		}
		
        return dataSet;
	}
}
