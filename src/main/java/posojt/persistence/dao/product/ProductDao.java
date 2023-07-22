package posojt.persistence.dao.product;

import java.util.List;

import posojt.persistence.entity.Product;

public interface ProductDao {

	void saveProduct(Product product);

	List<Product> findProductByShop(int id);
	
	Product findProductById(int id);

	List<Product> getAllProducts();
	

}
