package aulas.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/teste")
public class TestResource {
	@GET
    @Produces(MediaType.TEXT_HTML)
    public String get() {
        return "API NO AR";
    }
}
