package posojt.persistence.entity;

import java.util.Date;
import java.util.List;

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
@Table(name = "order_details")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private Double total;
	
	@CreationTimestamp
	private Date created_at;
	
	@UpdateTimestamp
	private Date update_at;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
}
