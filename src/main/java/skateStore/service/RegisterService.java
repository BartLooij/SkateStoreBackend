package skateStore.service;

import skateStore.DAO.UserDAO;
import skateStore.model.RegistreerUser;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class RegisterService {

    private UserDAO userDAO;

    @Inject
    public RegisterService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public Response create(RegistreerUser user) {
        userDAO.create(user);
        return Response.ok().build();
    }
}
