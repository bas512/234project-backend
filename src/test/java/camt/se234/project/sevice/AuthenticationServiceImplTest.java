package camt.se234.project.sevice;

import camt.se234.project.dao.UserDao;
import camt.se234.project.dao.UserDaoImpl;
import camt.se234.project.entity.User;
import camt.se234.project.service.AuthenticationServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthenticationServiceImplTest {

    UserDao userDao;
    AuthenticationServiceImpl authenticationService;

    @Before
    public void setup(){
        userDao = mock(UserDao.class);
        authenticationService = new AuthenticationServiceImpl();
        authenticationService.setUserDao(userDao);

    }

    @Test
    public void authenticate(){
        when(userDao.getUser("admin","admin")).thenReturn(new User(null,"admin","admin","admin"));
        when(userDao.getUser("user","user")).thenReturn(new User(null,"user","user","user"));
        when(userDao.getUser("ccc","003")).thenReturn(new User(null,"ccc","003","user"));

        assertThat(userDao.getUser("admin","admin"),is(new User(null,"admin","admin","admin")));


    }
}
