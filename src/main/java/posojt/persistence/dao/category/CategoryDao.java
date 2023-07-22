package posojt.persistence.dao.category;

import java.util.List;

import posojt.persistence.entity.Category;

public interface CategoryDao {
	List<Category> getAllCategories();
}
