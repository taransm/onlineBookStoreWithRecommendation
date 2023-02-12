package bookstore.ejb;

import javax.ejb.Remote;

@Remote
public interface RecommendationSingletonRemote {

	
	void calculateRecommendataion();
}
