package org.acme.rest;

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
        saveToDB(value);
        return value + "..." + value + "..." + value + "..." + value + "...";
    }

    private void saveToDB(String value) {
        AccessLog requestLog = new AccessLog();
        requestLog.timestamp = new Date();
        requestLog.requestValue = value;
        requestLog.responseValue = returnValue;
        requestLog.persist();
    }
}
