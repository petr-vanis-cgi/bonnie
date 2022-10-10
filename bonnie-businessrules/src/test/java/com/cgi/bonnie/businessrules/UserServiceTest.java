package com.cgi.bonnie.businessrules;

import com.cgi.bonnie.businessrules.user.User;
import com.cgi.bonnie.businessrules.user.UserService;
import com.cgi.bonnie.businessrules.user.UserStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class UserServiceTest {

    UserStorage userStorage;

    UserService userService;

    @BeforeEach
    public void setup() {
        userStorage = Mockito.mock(UserStorage.class);

        userService = new UserService(userStorage);
    }

    @Test
    public void expectLoadUserCallsLoad() {
        userService.loadUser(1L);

        verify(userStorage).load(1L);
    }

    @Test
    public void expectCreateUserCallsCreateUser() {
        final String name = "name";
        final String password = "password";
        final Role role = Role.ADMIN;
        final User user = new User().withName(name).withRole(role);

        userService.createUser(name, password, role);

        verify(userStorage).create(user, password);
    }

    @Test
    public void expectSaveCallsSave() {
        User user = new User().withId(1L).withName("name").withRole(Role.ADMIN);

        userService.save(user);

        verify(userStorage).save(user);
    }
}
