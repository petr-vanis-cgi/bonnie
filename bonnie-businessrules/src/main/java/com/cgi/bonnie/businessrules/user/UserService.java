package com.cgi.bonnie.businessrules.user;

import com.cgi.bonnie.businessrules.Role;

import java.util.List;

public class UserService {

    final private UserStorage userServiceIf;

    final private AuthUserStorage authUserStorage;

    public UserService(UserStorage loader, AuthUserStorage storage) {
        this.userServiceIf = loader;
        this.authUserStorage = storage;
    }

    public User loadUser(long id){
        return userServiceIf.load(id);
    }

    public long createUser(String name, String password, Role role) {
        return userServiceIf.createUser(name, password, role);
    }

    public boolean save(User user) {
        return userServiceIf.save(user);
    }

    public List<User> getAllUsers() {return userServiceIf.getAllUsers();}

    public String getCurrentUsername() {return authUserStorage.getCurrentUsername();}

    public User getCurrentUser() {return userServiceIf.getUserByUsername(authUserStorage.getCurrentUsername());}

}
