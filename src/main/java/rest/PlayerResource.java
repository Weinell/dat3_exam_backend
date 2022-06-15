package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PlayerDTO;
import entities.Player;
import facades.PlayerFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("player")
public class PlayerResource {

    private static final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    private static final PlayerFacade facade = PlayerFacade.getFacade(emf);
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
        PlayerDTO playerDTO = GSON.fromJson(jsonContext, PlayerDTO.class);
        Player player = new Player(playerDTO);
        PlayerDTO created = new PlayerDTO(facade.create(player));
        return Response
                .ok()
                .entity(GSON.toJson(created))
                .build();
    }

    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getById(@PathParam("id") Long id) throws javassist.NotFoundException {
        PlayerDTO found = new PlayerDTO(facade.getById(id));
        return Response
                .ok("SUCCESS")
                .entity(GSON.toJson(found))
                .build();
    }

    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()    {
        List<PlayerDTO> playerDTOS = new ArrayList<>();
        for (Player p : facade.getAll()) {
            playerDTOS.add(new PlayerDTO(p));
        }
        return Response
                .ok()
                .entity(GSON.toJson(playerDTOS))
                .build();
    }

//    @Path("update/{id}")
//    @PUT
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response update(@PathParam("id") Long id, String jsonContext) throws javassist.NotFoundException {
//        PlayerDTO playerDTO = GSON.fromJson(jsonContext, PlayerDTO.class);
//        Player player = new Player(playerDTO);
//        player.setId(id);
//        PlayerDTO updated = new PlayerDTO(facade.update(player));
//        return Response
//                .ok("SUCCESS")
//                .entity(GSON.toJson(updated))
//                .build();
//    }
    
    

}
