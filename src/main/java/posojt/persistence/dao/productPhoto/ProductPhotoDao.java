package posojt.persistence.dao.productPhoto;

import java.util.List;

import posojt.persistence.entity.ProductPhoto;

public interface ProductPhotoDao {
	void saveImage(ProductPhoto productPhoto);
	
	List<ProductPhoto> findProductPhotoById(int id);
}
