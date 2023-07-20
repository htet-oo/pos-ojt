package posojt.persistence.dao.role;

import java.util.List;

import posojt.persistence.entity.Role;

public interface RoleDao {
	
	List<Role> getAllRoles();
	
	Role findById(int id);
}
