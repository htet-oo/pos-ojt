package posojt.bl.services.productPhoto.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import posojt.bl.dto.ProductPhotoDTO;
import posojt.bl.services.productPhoto.ProductPhotoService;
import posojt.persistence.dao.product.ProductDao;
import posojt.persistence.dao.productPhoto.ProductPhotoDao;
import posojt.persistence.entity.ProductPhoto;
import posojt.web.form.ProductImage;

@Service
public class ProductPhotoServiceImpl implements ProductPhotoService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductPhotoDao productPhotoDao;
	
	@Override
	public void saveImage(ProductImage productImage) {
		ProductPhoto productPhoto = new ProductPhoto();
		productPhoto.setCreated_at(new Date());
		productPhoto.setFile_name(productImage.getPhoto().getOriginalFilename());
		productPhoto.setProduct(productDao.findProductById(productImage.getProduct_id()));
		productPhotoDao.saveImage(productPhoto);
	}

	@Override
	public List<ProductPhotoDTO> findProductPhotoById(int id) {
		List<ProductPhoto> productPhotoList = productPhotoDao.findProductPhotoById(id);
		return productPhotoList.stream().map(productPhoto -> new ProductPhotoDTO(productPhoto)).toList();
	}


}
