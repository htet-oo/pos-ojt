package posojt.bl.services.category.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import posojt.bl.dto.CategoryDTO;
import posojt.bl.services.category.CategoryService;
import posojt.persistence.dao.category.CategoryDao;
import posojt.persistence.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<CategoryDTO> getAllCategories() {
		List<Category> categoryList = categoryDao.getAllCategories();
		return categoryList.stream().map(category -> new CategoryDTO(category)).toList();
	}

}
