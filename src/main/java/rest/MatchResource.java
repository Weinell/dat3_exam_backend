package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MatchDTO;
import entities.Match;
import facades.MatchFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

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


    @Path("create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(String jsonContext)  {
        MatchDTO matchDTO = GSON.fromJson(jsonContext, MatchDTO.class);
        Match match = new Match(matchDTO);
        MatchDTO created = new MatchDTO(facade.create(match));
        return Response
                .ok()
                .entity(GSON.toJson(created))
                .build();
    }

    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getById(@PathParam("id") Long id) throws NotFoundException, javassist.NotFoundException {
        MatchDTO found = new MatchDTO(facade.getById(id));
        return Response
                .ok("SUCCESS")
                .entity(GSON.toJson(found))
                .build();
    }

    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()    {
        List<MatchDTO> matchDTOS = new ArrayList<>();
        for (Match m : facade.getAll()) {
            matchDTOS.add(new MatchDTO(m));
        }
        return Response
                .ok()
                .entity(GSON.toJson(matchDTOS))
                .build();
    }
}
