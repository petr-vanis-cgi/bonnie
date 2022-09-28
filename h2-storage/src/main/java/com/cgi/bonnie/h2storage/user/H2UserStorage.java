package com.cgi.bonnie.h2storage.user;

import com.cgi.bonnie.businessrules.user.User;
import com.cgi.bonnie.businessrules.user.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class H2UserStorage implements UserStorage {

    final private H2UserRepository repository;
    final private UserMapper mapper;

    @Autowired
    public H2UserStorage(H2UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public boolean save(User o) {
        try {
            repository.save(mapper.fromUser(o));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public long create(User o, String password) {
        try {
            return repository.save(mapper.fromUser(o)).getId();
        } catch (Exception e) {
            return 0L;
        }
    }

    @Override
    public User load(long id) {
        return mapper.fromEntity(repository.findById(id).orElseThrow(() -> new IllegalStateException("User not found")));
    }

    @Override
    public User getUserByUsername(String username) {
        return mapper.fromEntity(repository.findByName(username));
    }

    @Override
    public long createUser(String name, String password, Role role) {
        AssemblyUser user = new AssemblyUser().withName(name).withPassword(password).withRole(role);
        repository.save(user);
        return user.getId();
    }

    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        repository.findAll().forEach(user -> result.add(mapper.fromEntity(user)));
        return result;
    }
}
