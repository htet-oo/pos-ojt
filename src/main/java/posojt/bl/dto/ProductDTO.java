package posojt.bl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import posojt.persistence.entity.Product;
import posojt.persistence.entity.Product.Type;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private int id;
	private String name;
	private Double price;
	private String color;
	private int count;
	private float size;
	private Type type;
	private boolean is_stock;
	private boolean is_cancel;
	private int subCategory_id;
	private String description;
	
	public ProductDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.color = product.getColor();
		this.count = product.getCount();
		this.size = product.getSize();
		this.type = product.getType();
		this.is_stock = product.getIs_stock();
		this.is_cancel = product.getIs_cancel();
		this.subCategory_id = product.getSubCategory().getId();
		this.description = product.getDescription();
	}
}
