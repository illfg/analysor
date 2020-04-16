package service;

import entity.User;
import mapper.UserMapper;


public class UserService extends DaoProvider {
    UserMapper mapper = getMapper(UserMapper.class);

    public void insertUser(User user){
        mapper.insert(user);
        commit();
    }

    public User queryUser(String username){
        User user = mapper.selectUserByName(username);
        return user;
    }
}
