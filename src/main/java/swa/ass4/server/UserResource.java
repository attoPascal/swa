package swa.ass4.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
    
    @POST
	@Consumes("text/xml")
	@Produces("text/xml")
    public User addUser(User user) {
    	dao.addUser(user);
    	return dao.getUser(user.getUserName());
    }
	
	@GET
	@Path("/{username}")
    @Produces("text/xml")
	public User getUser(@PathParam("username") String userName) {
		return dao.getUser(userName);
	}
	
	@PUT
	@Path("/{username}")
	@Consumes("text/xml")
	@Produces("text/xml")
	public User updateUser(@PathParam("username") String userName, User user) {
		dao.updateUser(userName, user);
		
		return dao.getUser(userName);
	}
	
	@PUT
	@Path("/{username}")
	@Consumes("text/plain")
	@Produces("text/plain")
	public String setPassword(@PathParam("username") String userName, String password) {
		User user = dao.getUser(userName);
		user.setPassword(password);
		
		return "Password changed";
	}
	
	@DELETE
	@Path("/{username}")
	public void deleteUser(@PathParam("username") String userName) {
		dao.deleteUser(userName);
	}
}
