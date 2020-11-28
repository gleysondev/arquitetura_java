package aulas.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import aulas.model.Oficial;
import aulas.respository.OficialRepository;

@Path("/oficiais")
public class OficialResource {
	private OficialRepository repository = new OficialRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Oficial> list() {
        return repository.getAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Oficial get(@PathParam("id") int id) {
        return repository.get(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Oficial ofical)
    {
        try{
            repository.add(ofical);
            return Response.status(Response.Status.CREATED).entity(ofical).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("id") int id, Oficial ofical)
    {
        Oficial p = repository.get(id);
        if(p == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        try{
            repository.edit(ofical);
            return Response.status(Response.Status.OK).entity(ofical).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id)
    {
        Oficial p = repository.get(id);
        if(p == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        try{
            repository.delete(id);
            return Response.status(Response.Status.OK).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }
}
