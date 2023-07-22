package posojt.bl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import posojt.persistence.entity.SubCategory;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryDTO {
	private int id;
	private String name;
	private int category_id;
	
	public SubCategoryDTO(SubCategory subCategory) {
		this.id = subCategory.getId();
		this.name = subCategory.getName();
		this.category_id = subCategory.getCategory().getId();
		
	}
}
