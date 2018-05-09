package camt.se234.project.dao;

import camt.se234.project.entity.User;
import camt.se234.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

//    List<User> user;
//    public UserDaoImpl(){
//        user = new ArrayList<>();
//        user.add(new User("aaa","a001"));
//        user.add(new User("bbb","b002"));
//        user.add(new User("ccc","c003"));
//    }

    @Autowired
    UserRepository userRepository;
    @Override
    public User getUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }


}
