package posojt.persistence.dao.subcategory.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import posojt.persistence.dao.subcategory.SubCategoryDao;
import posojt.persistence.entity.SubCategory;



@Repository
@Transactional
public class SubCategoryDaoImpl implements SubCategoryDao {
    private static String TABLENAME = "SubCategory";

    private static String QUERY = "FROM " + TABLENAME;
    
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<SubCategory> getAllSubCategories() {
		StringBuffer stringBuf = new StringBuffer(QUERY);
		@SuppressWarnings("unchecked")
		Query<SubCategory> query = getSession().createQuery(stringBuf.toString());
		return query.list();
	}
	
	@Override
	public SubCategory findById(int id) {
		return getSession().get(SubCategory.class, id);
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
