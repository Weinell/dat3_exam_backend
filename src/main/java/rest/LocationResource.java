package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.LocationDTO;
import dtos.MatchDTO;
import entities.Location;
import entities.Match;
import facades.LocationFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("location")
public class LocationResource {

    private static final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    private static final LocationFacade facade = LocationFacade.getFacade(emf);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

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
        LocationDTO locationDTO = GSON.fromJson(jsonContext, LocationDTO.class);
        Location location = new Location(locationDTO);
        LocationDTO created = new LocationDTO(facade.create(location));
        return Response
                .ok()
                .entity(GSON.toJson(created))
                .build();
    }

    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getById(@PathParam("id") Long id) throws javassist.NotFoundException {
        LocationDTO found = new LocationDTO(facade.getById(id));
        return Response
                .ok("SUCCESS")
                .entity(GSON.toJson(found))
                .build();
    }

    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()    {
        List<LocationDTO> locationDTOS = new ArrayList<>();
        for (Location l : facade.getAll()) {
            locationDTOS.add(new LocationDTO(l));
        }
        return Response
                .ok()
                .entity(GSON.toJson(locationDTOS))
                .build();
    }

    @Path("update/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, String jsonContext) throws javassist.NotFoundException {
        LocationDTO locationDTO = GSON.fromJson(jsonContext, LocationDTO.class);
        Location location = new Location(locationDTO);
        location.setId(id);
        LocationDTO updated = new LocationDTO(facade.update(location));
        return Response
                .ok("SUCCESS")
                .entity(GSON.toJson(updated))
                .build();
    }
}
