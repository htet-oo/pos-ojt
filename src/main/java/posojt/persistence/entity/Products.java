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
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false,length = 200)
	private String description;
	
	@Column(nullable = false)
	private Double price;
	
	@Column(nullable = false)
	private int count;
	
	private int size;
	
	private String color;
	
	@Column(nullable = false)
	private Type type;
	
	@Column(nullable = false)
	private Boolean is_stock;
	
	@Column(nullable = false)
	private Boolean is_cancel;
	
	@CreationTimestamp
	private Date created_at;
	
	@UpdateTimestamp
	private Date update_at;
	
	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shops shop;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<Order_details> order_details;
	
	@ManyToOne
	@JoinColumn(name = "sub_category_id")
	private Sub_categories sub_categories;
	
	@OneToMany(mappedBy = "products",cascade = CascadeType.ALL)
	private List<Product_photos> product_photos;
	
	public enum Type{
		instock,preorder;
	}

}
