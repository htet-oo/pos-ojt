package posojt.persistence.dao.subcategory;

import java.util.List;

import posojt.persistence.entity.SubCategory;

public interface SubCategoryDao {
	List<SubCategory> getAllSubCategories();
	
	SubCategory findById(int id);
}
