package posojt.persistence.dao.shop.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import posojt.bl.dto.ShopDTO;
import posojt.persistence.dao.shop.ShopDao;
import posojt.persistence.entity.Shop;
import posojt.persistence.entity.User;


@Repository
@Transactional
public class ShopDaoImpl implements ShopDao {
    private static String TABLENAME = "Shop";

    private static String QUERY = "FROM " + TABLENAME;
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveShop(Shop shop) {
		getSession().save(shop);
		
	}
	
	@Override
	public List<Shop> getAllShops() {
		StringBuffer stringBuf = new StringBuffer(QUERY);
		@SuppressWarnings("unchecked")
		Query<Shop> query = getSession().createQuery(stringBuf.toString());
		return query.list();
	}
	
	@Override
	public Shop searchShopById(int id) {
		return getSession().get(Shop.class, id);
	}
	
	@Override
	public void editShop(Shop shop) {
		System.out.println("this is from dao" + shop.getId());
		String sql = "UPDATE Shop SET address = :address, cover_photo = :coverPhoto, logo = :logo, update_at = :updatedAt, name = :name, phone_number =:phoneNumber, summary =:summary WHERE id = :id";
		Query<?> query = getSession().createQuery(sql);
		query.setParameter("address", shop.getAddress());
		query.setParameter("coverPhoto", shop.getCover_photo());
		query.setParameter("logo", shop.getLogo());
		query.setParameter("updatedAt", shop.getUpdate_at());
		query.setParameter("name", shop.getName());
		query.setParameter("phoneNumber", shop.getPhone_number());
		query.setParameter("summary", shop.getSummary());
		query.setParameter("id", shop.getId());
		query.executeUpdate();
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}


}
