package posojt.persistence.dao.recoveryPassword.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import posojt.persistence.dao.recoveryPassword.RecoveryPasswordDao;
import posojt.persistence.entity.PasswordReset;

@Repository
@Transactional
public class RecoveryPasswordDaoImpl implements RecoveryPasswordDao {
    private static String TABLENAME = "PasswordReset";

    private static String QUERY = "FROM " + TABLENAME;
    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void setData(PasswordReset passwordReset) {
		getSession().save(passwordReset);
		
	}
	
	@Override
	public PasswordReset findResetPasswordToken(String resetPasswordToken) {
		StringBuffer stringBuf = new StringBuffer(QUERY);
		stringBuf.append(" WHERE token =: resetPasswordToken");
		return getSession().createQuery(stringBuf.toString(),PasswordReset.class).setParameter("resetPasswordToken", resetPasswordToken).getSingleResult();
	}
	
	@Override
	public PasswordReset searchByEmail(String email) {
		StringBuffer stringBuf = new StringBuffer(QUERY);
		stringBuf.append(" WHERE email =: email");
		return getSession().createQuery(stringBuf.toString(),PasswordReset.class).setParameter("email", email).getSingleResult();
	}
	
	@Override
	public void dropPasswordReset(PasswordReset passwordReset) {
		getSession().delete(passwordReset);
		
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
