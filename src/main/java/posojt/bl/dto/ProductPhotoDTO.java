package posojt.bl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import posojt.persistence.entity.ProductPhoto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPhotoDTO {
	private int id;
	private String fileName;
	
	public ProductPhotoDTO(ProductPhoto productPhoto) {
		this.id = productPhoto.getId();
		this.fileName = productPhoto.getFile_name();
	}
 }
