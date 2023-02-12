package bookstore.ejb;

import javax.ejb.Local;

@Local
public interface RecommendationSingletonLocal {

	void calculateRecommendataion();

}
