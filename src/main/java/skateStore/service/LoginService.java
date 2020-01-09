package skateStore.service;

import skateStore.DAO.UserDAO;
import skateStore.model.LoginUser;
import skateStore.model.User;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class LoginService {

    private UserDAO userDAO;

    @Inject
    public LoginService(UserDAO userDAO){
        this.userDAO = userDAO;
        System.out.println("called" + userDAO);
    }

    public User onLogin(LoginUser credentials) {
        User user = userDAO.findUserByLoginCredentials(credentials);
        System.out.println(Response.ok().entity(user).build());
        return user;
    }
}
