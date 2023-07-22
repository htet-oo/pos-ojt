package posojt.bl.services.product;

import java.util.List;

import posojt.bl.dto.ProductDTO;
import posojt.web.form.ProductRegister;

public interface ProductService {
	void saveProduct(ProductRegister productRegister);
	
	List<ProductDTO> findProductByShop(int id);
	List<ProductDTO> getAllProducts();
	ProductDTO findProductByProductId(int id);
	
}
