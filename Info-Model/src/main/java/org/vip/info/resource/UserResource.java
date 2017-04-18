package org.vip.info.resource;

import org.vip.info.model.User;
import org.vip.info.dao.UserRepository;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserResource {

    private UserRepository users;

    public UserResource(UserRepository users) {
        this.users = users;
    }

    @POST
    @Path("/fname/{fname}/lname/{lname}")
    public Response addUser(@PathParam("fname") String fname,
                            @PathParam("lname") String lname) {
        User user = new User(fname, lname);
        users.createUser(user);
        return Response.accepted().build();
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") long id) {
        User user = users.findUser(id);
        if (user != null) {
            return Response.status(Response.Status.ACCEPTED).entity(user).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/")
    public Response getUsers() {
        return Response.status(Response.Status.ACCEPTED).entity(users.findUsers()).build();
    }

}
