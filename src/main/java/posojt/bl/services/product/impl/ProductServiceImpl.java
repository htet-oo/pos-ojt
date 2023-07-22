package posojt.bl.services.product.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import posojt.bl.dto.ProductDTO;
import posojt.bl.services.product.ProductService;
import posojt.bl.services.shop.ShopService;
import posojt.persistence.dao.product.ProductDao;
import posojt.persistence.dao.shop.ShopDao;
import posojt.persistence.dao.subcategory.SubCategoryDao;
import posojt.persistence.entity.Product;
import posojt.web.form.ProductRegister;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private SubCategoryDao subCategoryDao;
	
	@Autowired
	private ShopDao shopDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public void saveProduct(ProductRegister productRegister) {
		Product product = new Product();
		product.setColor(productRegister.getColor());
		product.setCount(productRegister.getCount());
		product.setCreated_at(new Date());
		product.setDescription(productRegister.getDescription());
		product.setIs_cancel(false);
		product.setIs_stock(true);
		product.setName(productRegister.getName());
		product.setPrice(productRegister.getPrice());
		product.setSize(productRegister.getSize());
		product.setSubCategory(subCategoryDao.findById(productRegister.getSubCategory_id()));
		product.setShop(shopDao.searchShopById(productRegister.getShopId()));
		product.setType(productRegister.getType());
		
		productDao.saveProduct(product);
	}

	@Override
	public List<ProductDTO> findProductByShop(int id) {
		List<Product> productList = productDao.findProductByShop(id);
		return productList.stream().map(product -> new ProductDTO(product)).toList();
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> productList = productDao.getAllProducts();
		return productList.stream().map(product -> new ProductDTO(product)).toList();
	}

	@Override
	public ProductDTO findProductByProductId(int id) {
		Product product = productDao.findProductById(id);
		return new ProductDTO(product);
	}


}
