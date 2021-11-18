package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import web.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> allread();
    void save(User user);
    User show (int id);
    void update(User usernew);
    void delete(int id);

    @Override
    User loadUserByUsername(String s) throws UsernameNotFoundException;
}
