package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allread() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User show(int id) {
        TypedQuery<User> tp = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        tp.setParameter("id", id);
        return tp.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public void update(User usernew) {
        entityManager.merge(usernew);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(show(id));
    }

    @Override
    public User getUserByName(String username1) {
        TypedQuery<User> tp = entityManager.createQuery("select u from User u where u.username = :username", User.class);
        tp.setParameter("username", username1);
        return tp.getResultList().stream().findFirst().orElse(null);
    }
}
