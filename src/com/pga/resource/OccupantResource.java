package com.pga.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.pga.ro.AccountRO;
import com.pga.ro.OccupantHistoryRO;
import com.pga.ro.OccupantRO;
import com.pga.service.OccupantService;


@Path("/occupant")
public class OccupantResource {
	
	@GET
    @Path("{occupantId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOccupant(@PathParam("occupantId") int occupantId) {
        System.out.println("Request received to get occupant with id " + occupantId);
        OccupantRO occupant = OccupantService.getOccupantById(occupantId);
        return Response.ok(occupant).build();
    }
	
	@GET
    @Path("{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccount(@PathParam("accountId") int accountId) {
        System.out.println("Request received to get account with id " + accountId);
        AccountRO account = OccupantService.getAccountById(accountId);
        return Response.ok(account).build();
    }
	
	@GET
    @Path("{occupantHistoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOccupantHistory(@PathParam("occupantHistoryId") int occupantHistoryId) {
        System.out.println("Request received to get account with id " + occupantHistoryId);
        OccupantHistoryRO occupantHistory = OccupantService.getOccupantHistoryById(occupantHistoryId);
        return Response.ok(occupantHistory).build();
    }
	
	

}
