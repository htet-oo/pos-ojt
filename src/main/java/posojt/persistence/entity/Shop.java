package posojt.persistence.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "shops")
public class Shop {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false,length = 200)
	private String summary;
	
	@Column(nullable = false)
	private String logo;
	
	@Column(nullable = false)
	private String cover_photo;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String phon_number;
	
	private boolean is_reject;
	
	@CreationTimestamp
	private Date created_at;
	
	@UpdateTimestamp
	private Date update_at;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "shop",cascade = CascadeType.ALL)
	private List<Product> product;
	
	
	
	

}
