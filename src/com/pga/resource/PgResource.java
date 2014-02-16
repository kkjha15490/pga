package com.pga.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pga.ro.PgRO;
import com.pga.service.PgService;
import com.rest.ro.AwsomeRO;

@Path("/pg")
public class PgResource {
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {

        return "Hello Awsome";
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrackInJSON() {

        AwsomeRO track = new AwsomeRO();
        track.setId("10");
        track.setName("Awsome Boy");

        return Response.ok(track).build();
    }
    
    
 // http://localhost:8080/rest/pg/bed/query?id=1
    @GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBedsInARoom(@QueryParam("id") int id) {
        System.out.println("Request received to get pg with id " + id);
        PgRO pg = PgService.getPgById(id);
        return Response.ok(pg).build();
    }
}
