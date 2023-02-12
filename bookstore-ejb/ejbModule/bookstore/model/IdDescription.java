package bookstore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class IdDescription implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    private Integer genreId;
    private String genreDesc;
    
	public IdDescription() {
	}
	
	public IdDescription(int id, String description) {
		this.genreId = id;
		this.genreDesc = description;
	}

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer id) {
		this.genreId = id;
	}

	public String getGenreDesc() {
		return genreDesc;
	}

	public void setGenreDesc(String description) {
		this.genreDesc = description;
	}
}