package posojt.bl.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import posojt.persistence.entity.Shop;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTO {
	
	private int id;
	private String name;
	private String summary;
	private String logo;
	private String cover_photo;
	private String address;
	private String phone_number;
	
	public ShopDTO(Shop shop) {
		this.id = shop.getId();
		this.name = shop.getName();
		this.summary = shop.getSummary();
		this.logo = shop.getLogo();
		this.cover_photo = shop.getCover_photo();
		this.address = shop.getAddress();
		this.phone_number = shop.getPhone_number();
	}
	
	
}
