package com.pga.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pga.ro.RoomRO;
import com.pga.service.RoomService;

@Path("/room")
public class RoomResource {
	
	@GET
    @Path("{roomId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoom(@PathParam("roomId") int roomId) {
        System.out.println("Request received to get room with id " + roomId);
        RoomRO room = RoomService.getRoomById(roomId);
        return Response.ok(room).build();
    }

}
