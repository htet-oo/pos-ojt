package posojt.bl.services.shop.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import posojt.bl.dto.ShopDTO;
import posojt.bl.services.shop.ShopService;
import posojt.bl.services.user.UserService;
import posojt.persistence.dao.shop.ShopDao;
import posojt.persistence.entity.Shop;
import posojt.persistence.entity.User;
import posojt.web.form.ShopRegister;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDao shopDao;
	
	@Autowired
	private UserService userService;
	
	@Override
	public void saveShop(ShopRegister shopRegister) {
		Shop shop = new Shop();
		shop.setAddress(shopRegister.getAddress());
		shop.setCover_photo(shopRegister.getCoverPhoto().getOriginalFilename());
		shop.setCreated_at(new Date());
		shop.setLogo(shopRegister.getLogo().getOriginalFilename());
		shop.setName(shopRegister.getName());
		shop.setPhone_number(shopRegister.getPhone());
		shop.setSummary(shopRegister.getSummary());
		
		User user = userService.findByEmail(shopRegister.getEmail());
		shop.setUser(user);
		
		shopDao.saveShop(shop);
		
	}

	@Override
	public List<ShopDTO> getAllShops() {
		List<Shop> shopList = shopDao.getAllShops();
		return shopList.stream().map(shop -> new ShopDTO(shop)).toList();
	}

	@Override
	public ShopDTO searchShopById(int id) {
		return new ShopDTO(shopDao.searchShopById(id));
	}

	@Override
	public void editShop(ShopRegister shopRegister) {
		System.out.println("this is from service");
		Shop shop = new Shop();
		shop.setId(shopRegister.getId());
		shop.setAddress(shopRegister.getAddress());
		shop.setCover_photo(shopRegister.getCoverPhoto().getOriginalFilename());
		shop.setLogo(shopRegister.getLogo().getOriginalFilename());
		shop.setName(shopRegister.getName());
		shop.setPhone_number(shopRegister.getPhone());
		shop.setSummary(shopRegister.getSummary());
		shop.setUpdate_at(new Date());
		shopDao.editShop(shop);
	}


}
