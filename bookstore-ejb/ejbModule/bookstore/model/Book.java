package bookstore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String title;
    private String author;
    private String edition;
    private Double ratings;
    private Integer reviews;
    private String synopsis;
    private Integer genreId;
    private String genreDesc;
    private Integer categoryId;
    private String categoryDesc;
    private Double price;
    

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Integer getReviews() {
		return reviews;
	}

	public void setReviews(Integer reviews) {
		this.reviews = reviews;
	}

	public Double getRatings() {
		return ratings;
	}

	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getGenreDesc() {
		return genreDesc;
	}

	public void setGenreDesc(String genreDesc) {
		this.genreDesc = genreDesc;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
			.append("Book ").append("\n[")
			.append("bookId=").append(bookId).append(", ")
			.append("title=").append(title).append(", ")
			.append("price=").append(price).append(", ")
			.append("author=").append(author).append(", ")
			.append("edition=").append(edition).append(", ")
			.append("reviews=").append(reviews).append(", ")
			.append("ratings=").append(ratings).append(", ")
			.append("synopsis=").append(synopsis).append(", ")
			.append("genreId=").append(genreId).append(", ")
			.append("genreDesc=").append(genreDesc).append(", ")
			.append("categoryId=").append(categoryId).append(", ")
			.append("categoryDesc=").append(categoryDesc)
			.append("]");
		return builder.toString();
	}
    
    
}