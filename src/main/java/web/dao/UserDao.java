package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> allread();
    void save(User user);
    User show (int id);
    void update(User usernew);
    void delete(int id);
    User getUserByName(String name);
}
