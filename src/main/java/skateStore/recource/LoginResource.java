package skateStore.recource;

import skateStore.model.LoginUser;
import skateStore.model.User;
import skateStore.service.LoginService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {

    private final LoginService service;

    @Inject
    public LoginResource(LoginService service) {
        this.service = service;
        System.out.println("called 2");
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public User onLogin(@NotNull @Valid LoginUser credentials) {
        System.out.println("called"  +  service);
        System.out.println("1" + credentials);
        return service.onLogin(credentials);
    }
}
