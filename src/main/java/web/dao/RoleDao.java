package web.dao;

import web.model.Role;

import java.util.Set;

public interface RoleDao {
    Set<Role> allread();
    void save(Role roles);
//    Roles show(int id);
//    void update(int id, Roles rolesnew);
    public void delete(String name);

    Role getRole(String name);
}
