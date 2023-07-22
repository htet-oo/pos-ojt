package posojt.persistence.dao.product.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import posojt.persistence.dao.product.ProductDao;
import posojt.persistence.entity.Product;
import posojt.persistence.entity.Role;


@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
    private static String TABLENAME = "Product";

    private static String QUERY = "FROM " + TABLENAME;
    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveProduct(Product product) {
		getSession().save(product);		
	}
	
	@Override
	public List<Product> findProductByShop(int id) {
		StringBuffer stringBuf = new StringBuffer(QUERY);
		stringBuf.append(" WHERE shop_id =:shop_id");
		@SuppressWarnings("unchecked")
		List<Product> product = getSession().createQuery(stringBuf.toString()).setParameter("shop_id", id).list();
		return product;
	}
	
	@Override
	public Product findProductById(int id) {
		return getSession().get(Product.class, id);
	}
	
	@Override
	public List<Product> getAllProducts() {
		StringBuffer stringBuf = new StringBuffer(QUERY);
		@SuppressWarnings("unchecked")
		Query<Product> query = getSession().createQuery(stringBuf.toString());
		return query.list();
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}


}
