package posojt.bl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import posojt.persistence.entity.Category;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
	private int id;
	private String name;
	
	public CategoryDTO(Category category) {
		this.id = category.getId();
		this.name = category.getName();
	}
}
