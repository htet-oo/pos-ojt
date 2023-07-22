package posojt.web.form;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ProductImage {
	private int id;
	private int product_id;
	private MultipartFile photo;
	private int shopId;

}
