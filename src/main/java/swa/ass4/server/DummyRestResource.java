package swa.ass4.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/parties")
public class DummyRestResource {

    @Context
    UriInfo url;

    @Context
    Request request;

    String name;

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPartyCount() throws Exception
    {
        return String.valueOf(123456);
    }

}