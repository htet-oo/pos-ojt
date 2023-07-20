package posojt.persistence.dao.user.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import posojt.persistence.dao.user.UserDao;
import posojt.persistence.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    private static String TABLENAME = "User";

    private static String QUERY = "FROM " + TABLENAME;
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<User> getAllUsers() {
		StringBuffer stringBuf = new StringBuffer(QUERY);
		@SuppressWarnings("unchecked")
		Query<User> query = getSession().createQuery(stringBuf.toString());
		return query.list();
	}
	
	@Override
	public void saveUser(User user) {
		getSession().save(user);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User findByEmail(String email) {
		StringBuffer stringBuf = new StringBuffer(QUERY);
		stringBuf.append(" WHERE email =:email");
		List<User> user = new ArrayList<>();
		user = getSession().createQuery(stringBuf.toString()).setParameter("email", email).list();
		return (!user.isEmpty()) ? user.get(0) : null;
	}
	
	@Override
	public void updatePassword(User user) {
		String sql = "UPDATE User SET password = :password, update_at = :updatedAt WHERE id = :id";
		Query<?> query = getSession().createQuery(sql);
		query.setParameter("password", user.getPassword());
		query.setParameter("updatedAt", user.getUpdate_at());
		query.setParameter("id", user.getId());
		query.executeUpdate();
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}




}
