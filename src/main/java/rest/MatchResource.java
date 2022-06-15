package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("match")
public class MatchResource {

    @Path("alive")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String checkAlive() {
        return "{\"msg\":\"This endpoint works!\"}";
    }

}
