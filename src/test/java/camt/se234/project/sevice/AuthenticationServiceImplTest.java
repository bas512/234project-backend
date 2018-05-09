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
        when(userDao.getUser("aaa","001")).thenReturn(new User(null,"aaa","001","admin"));
        when(userDao.getUser("bbb","002")).thenReturn(new User(null,"bbb","002","user"));
        when(userDao.getUser("ccc","003")).thenReturn(new User(null,"ccc","003","user"));

        assertThat(userDao.getUser("aaa","001"),is(new User(null,"aaa","001","admin")));


    }
}
