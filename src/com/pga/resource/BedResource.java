package com.pga.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pga.ro.BedPriceHistoryRO;
import com.pga.ro.BedRO;
import com.pga.ro.PriceRO;
import com.pga.service.BedService;


@Path("/bed")
public class BedResource {
	
	@GET
    @Path("{bedId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBed(@PathParam("bedId") int bedId) {
        System.out.println("Request received to get bed with id " + bedId);
        BedRO bed = BedService.getBedById(bedId);
        return Response.ok(bed).build();
    }
	
	@GET
    @Path("{priceId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrice(@PathParam("priceId") int priceId) {
        System.out.println("Request received to get price with id " + priceId);
        PriceRO price = BedService.getPriceById(priceId);
        return Response.ok(price).build();
    }
	
	@GET
    @Path("{BedPriceHistoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBedPriceHistory(@PathParam("BedPriceHistoryId") int bedPriceHistoryId) {
        System.out.println("Request received to get bedPriceHistory with id " + bedPriceHistoryId);
        BedPriceHistoryRO bedPriceHistory = BedService.getBedPriceHistoryById(bedPriceHistoryId);
        return Response.ok(bedPriceHistory).build();
    }

}
