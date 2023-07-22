package posojt.bl.services.subcategory.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import posojt.bl.dto.SubCategoryDTO;
import posojt.bl.services.subcategory.SubCategoryService;
import posojt.persistence.dao.subcategory.SubCategoryDao;
import posojt.persistence.entity.SubCategory;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
	
	@Autowired
	private SubCategoryDao subCategoryDao;
	
	@Override
	public List<SubCategoryDTO> getAllSubCategories() {
		List<SubCategory> subCategoryList = subCategoryDao.getAllSubCategories();
		return subCategoryList.stream().map(subCategory -> new SubCategoryDTO(subCategory)).toList();
	}

}
