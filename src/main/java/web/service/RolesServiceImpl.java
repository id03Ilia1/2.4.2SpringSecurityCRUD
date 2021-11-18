package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.dao.UserDao;
import web.model.Role;

import java.util.List;
import java.util.Set;

@Service
public class RolesServiceImpl implements RolesService{
    private final RoleDao roleDao;

    @Autowired
    public RolesServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public Set<Role> allread() {
        return roleDao.allread();
    }

    @Override
    @Transactional
    public void save(Role roles) {
        roleDao.save(roles);
    }

//    @Override
//    @Transactional
//    public Roles show(int id) {
//        return roleDao.show(id);
//    }
//
//    @Override
//    @Transactional
//    public void update(int id, Roles rolesnew) {
//        roleDao.update(id,rolesnew);
//    }

    @Override
    @Transactional
    public void delete(String name) {
        roleDao.delete(name);
    }

    @Override
    @Transactional
    public Role getRole(String name) {
        return roleDao.getRole(name);
    }
}
