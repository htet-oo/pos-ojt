package posojt.persistence.dao.category.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import posojt.persistence.dao.category.CategoryDao;
import posojt.persistence.entity.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {
    private static String TABLENAME = "Category";

    private static String QUERY = "FROM " + TABLENAME;
    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> getAllCategories() {
		StringBuffer stringBuf = new StringBuffer(QUERY);
		@SuppressWarnings("unchecked")
		Query<Category> query = getSession().createQuery(stringBuf.toString());
		return query.list();
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}


}
