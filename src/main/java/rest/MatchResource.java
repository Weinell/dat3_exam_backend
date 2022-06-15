package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.MatchFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("match")
public class MatchResource {

    private static final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    private static final MatchFacade facade = MatchFacade.getFacade(emf);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Path("alive")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String checkAlive() {
        return "{\"msg\":\"This endpoint works!\"}";
    }

}
