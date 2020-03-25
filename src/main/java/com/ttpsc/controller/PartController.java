package com.ttpsc.controller;

import com.ttpsc.entity.Car;
import com.ttpsc.entity.Part;
import com.ttpsc.service.PartService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/parts")
public class PartController {

    private PartService partService;

    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Part getPart(@PathParam("id") Long id) {
        Optional<Part> foundPart = partService.getPart(id);

        if (foundPart.isPresent()) {
            return foundPart.get();
        } else
            throw new IllegalArgumentException("No Part with ID = " + id + " found!");
    }

    @POST
    public void addPart(Part part) {
        partService.addPart(part);
    }

    @PUT
    @Path("{id}")
    public void updatePart(@PathParam("id") Long id, Part part){
        partService.updatePart(id, part);
    }

    @DELETE
    @Path("{id}")
    public void deletePart(@PathParam("id") Long id) {
        partService.deletePart(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Part> getParts() {
        return partService.getParts();
    }
}
