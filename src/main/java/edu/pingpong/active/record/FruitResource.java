package edu.pingpong.active.record;


import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/fruits")
public class FruitResource {

    @Inject
    FruitActiveRecord activeRecord;

    public FruitResource() {
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response fruitsData() {
        return Response.ok(activeRecord.getData(), MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addData(@Valid Fruit fruit) {
        activeRecord.addFruit(fruit);
        return Response.accepted(fruit).build();
    }

    @DELETE
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteData(@Valid Fruit fruit) {
        activeRecord.removeFruit(fruit.getName());
        return Response.accepted(fruit).build();
    }

    @GET
    @Path("/{fruitname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData(@PathParam("fruitname") String fruitname) {
        Optional<Fruit> fruit = activeRecord.getFruit(fruitname);
        return fruit.isPresent() ? Response.ok(fruit).build() : Response.status(Response.Status.NOT_FOUND).entity("The fruit with name " + fruitname + " doesn't exist.").build();
    }
}