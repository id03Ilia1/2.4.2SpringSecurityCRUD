package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> allread() {
        return new HashSet<>(
                entityManager.createQuery("FROM Role", Role.class).getResultList());
    }
    @Override
    public void save(Role roles) {
        entityManager.persist(roles);
    }

    @Override
    public Role getRole(String name) {
        return entityManager
                .createQuery("SELECT r FROM Role r WHERE r.rolen = :rolen", Role.class)
                .setParameter("rolen", name)
                .getSingleResult();
    }

//    @Override
//    public Roles show(int id) {
//        return entityManager.find(Roles.class, id);
//    }
//
//    @Override
//    public void update(int id, Roles rolesnew) {
//
//    }

    @Override
    public void delete(String name) {

//        entityManager.remove(show(id));
        entityManager
                .createQuery("DELETE FROM Role r WHERE r.rolen = :rolen", Role.class)
                .setParameter("rolen", name)
                .executeUpdate();
    }
}
