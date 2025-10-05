package org.acme.rest;

import java.util.Date;

import org.acme.entity.AccessLog;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("")
public class EchoResource {

    @GET
    @Path("/echo/{value}")
    @Produces(MediaType.TEXT_PLAIN)
    public String echo(@PathParam("value") String value) {
        String returnValue = value + "..." + value + "..." + value + "..." + value + "... stored in db!";
        saveToDB(value, returnValue);
        return returnValue;
    }

    @GET
    @Path("clean")
    @Transactional
    public void cleanUpDB() {
        AccessLog.deleteAll();
    }

    @Transactional
    public void saveToDB(String value, String returnValue) {
        AccessLog requestLog = new AccessLog();
        requestLog.timestamp = new Date();
        requestLog.requestValue = value;
        requestLog.responseValue = returnValue;
        requestLog.persist();
    }
}
