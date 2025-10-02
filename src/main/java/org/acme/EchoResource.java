package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/echo")
public class EchoResource {

    @GET
    @Path("{value}")
    @Produces(MediaType.TEXT_PLAIN)
    public String echo(@PathParam("value") String value) {
        return value + "..." + value + "..." + value + "..." + value + "...";
    }
}
