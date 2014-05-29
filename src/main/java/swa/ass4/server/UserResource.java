package swa.ass4.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import swa.ass4.domain.User;
import swa.ass4.server.data.DAO;
import swa.ass4.server.data.TestDataDAO;

@Path("/users")
public class UserResource {
	@Context
    UriInfo url;
	
    @Context
    Request request;
    
    String name;
    
    private DAO dao;
    
    public UserResource() {
    	dao = TestDataDAO.getInstance();
    }
    
    @GET
    @Produces("text/xml")
    public List<User> getUsers() {
    	return dao.getUsers();
    }
	
	@GET
	@Path("/{username}")
    @Produces("text/xml")
	public User getUser(@PathParam("username") String userName) {
		return dao.getUser(userName);
	}
	
	@POST
	@Path("/{username}")
	@Consumes("text/plain")
	@Produces("text/plain")
	public String setPassword(@PathParam("username") String userName, String password) {
		User user = dao.getUser(userName);
		user.setPassword(password);
		
		return "Password changed";
	}
}
