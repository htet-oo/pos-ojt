package posojt.bl.services.shop;

import java.util.List;

import posojt.bl.dto.ShopDTO;
import posojt.web.form.ShopRegister;

public interface ShopService {
	List<ShopDTO> getAllShops();
	ShopDTO searchShopById(int id);
	void saveShop(ShopRegister shopRegister);
	
	void editShop(ShopRegister shopRegister);
	
}
