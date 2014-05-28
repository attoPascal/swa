package swa.ass4.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import swa.ass4.domain.User;

@Path("/users/{username}")
public class RESTUserTest {
	@Context
    UriInfo url;

    @Context
    Request request;

    String name;
	
	@GET
    @Produces("text/xml")
	public User getUserByUsername(@PathParam("username") String userName) {
		if (userName != null && userName.equals("a1200595")) {
			return new User("Pascal", "Attwenger", "a1200595", "abc123", User.Role.STUDENT);
		} else {
			return new User();
		}
	}

}
