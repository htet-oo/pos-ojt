package posojt.persistence.dao.shop;

import java.util.List;

import posojt.bl.dto.ShopDTO;
import posojt.persistence.entity.Shop;

public interface ShopDao {
	void saveShop(Shop shop);

	List<Shop> getAllShops();

	Shop searchShopById(int id);

	void editShop(Shop shop);
}
