package posojt.web.form;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import posojt.bl.dto.ProductDTO;
import posojt.persistence.entity.Product.Type;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRegister {
	private String name;
	private Double price;
	private int count;
	private float size;
	private String color;
	private boolean is_stock;
	private boolean is_cancel;
	private int subCategory_id;
	private String description;
	private Type type;
	private int shopId;
	private int productId;
	
	public ProductRegister(ProductDTO productDTO) {
		this.is_stock=productDTO.is_stock();
		this.is_cancel = productDTO.is_cancel();
		this.name = productDTO.getName();
		this.price = productDTO.getPrice();
		this.color = productDTO.getColor();
		this.count = productDTO.getCount();
		this.size = productDTO.getSize();
		this.description = productDTO.getDescription();
		this.type = productDTO.getType();
		this.subCategory_id = productDTO.getSubCategory_id();
	}
	
	
	
	
}
