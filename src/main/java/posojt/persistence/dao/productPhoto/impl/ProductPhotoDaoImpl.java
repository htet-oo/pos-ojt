package posojt.persistence.dao.productPhoto.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import posojt.persistence.dao.productPhoto.ProductPhotoDao;
import posojt.persistence.entity.ProductPhoto;

@Repository
@Transactional
public class ProductPhotoDaoImpl implements ProductPhotoDao {
    private static String TABLENAME = "ProductPhoto";

    private static String QUERY = "FROM " + TABLENAME;

    @Autowired
	private SessionFactory sessionFactory;
    
	@Override
	public void saveImage(ProductPhoto productPhoto) {
		getSession().save(productPhoto);
		
	}
	
	@Override
	public List<ProductPhoto> findProductPhotoById(int id) {
		StringBuffer stringBuf = new StringBuffer(QUERY);
		stringBuf.append(" WHERE product_id =:product_id");
		@SuppressWarnings("unchecked")
		List<ProductPhoto> productPhoto = getSession().createQuery(stringBuf.toString()).setParameter("product_id", id).list();
		return productPhoto;
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}


}
