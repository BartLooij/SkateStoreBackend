package skateStore.recource;


import skateStore.model.RegistreerUser;
import skateStore.service.RegisterService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Path("register")
@Produces(MediaType.APPLICATION_JSON)
public class RegistreerResource {

    private final RegisterService registerService;

    @Inject
    public RegistreerResource(RegisterService registerService) {
        this.registerService = registerService;
    }

    @POST
    public Response registerUser(@Valid RegistreerUser registerCredentials) {
        return this.registerService.create(registerCredentials);
    }
}
