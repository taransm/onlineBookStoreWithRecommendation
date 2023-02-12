package bookstore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Cluster")
@NamedQueries({
    @NamedQuery(name = "Cluster.findByBookId", query = "SELECT c FROM Cluster c WHERE c.bookId = :bookId"),
    @NamedQuery(name = "Cluster.findByClustorNo", query = "SELECT c FROM Cluster c WHERE c.clusterNo = :clusterNo")
})
public class Cluster implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer clusterNo;
	@Id
    private Integer bookId;    
    
	public Cluster() {
	}
	
	public Cluster(int clusterNo, int bookId) {
		this.clusterNo = clusterNo;
		this.bookId = bookId;
	}
	
	public Integer getClusterNo() {
		return clusterNo;
	}

	public void setClusterNo(Integer clusterNo) {
		this.clusterNo = clusterNo;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
			.append("Cluster ").append("\n[")
			.append("clusterNo=").append(clusterNo).append(", ")
			.append("bookId=").append(bookId)
			.append("]");
		return builder.toString();
	}
    
    
}