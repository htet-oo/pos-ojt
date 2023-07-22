package posojt.bl.services.productPhoto;

import java.util.List;

import posojt.bl.dto.ProductPhotoDTO;
import posojt.web.form.ProductImage;

public interface ProductPhotoService {
	void saveImage(ProductImage productImage);
	List<ProductPhotoDTO> findProductPhotoById(int id); 
}
