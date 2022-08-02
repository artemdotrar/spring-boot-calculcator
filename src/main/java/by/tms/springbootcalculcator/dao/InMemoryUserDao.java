package by.tms.springbootcalculcator.dao;

import by.tms.springbootcalculcator.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryUserDao {
    List<User> users = new ArrayList<User>();

    public void save(User user){
        users.add(user);
    }

    public Optional<User> findByUsername(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

}
