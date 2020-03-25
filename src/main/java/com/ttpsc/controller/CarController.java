package com.ttpsc.controller;

import com.ttpsc.entity.Car;
import com.ttpsc.service.CarService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCar(@PathParam("id") Long id) {
        Optional<Car> foundCar = carService.getCar(id);

        if (foundCar.isPresent()) {
            return foundCar.get();
        } else
            throw new IllegalArgumentException("No Car with ID = " + id + " found!");
    }

    @POST
    public void addCar(Car car) {
        carService.addCar(car);
    }

    @PUT
    @Path("{id}")
    public void updateCar(@PathParam("id") Long id, Car car){
        carService.updateCar(id, car);
    }

    @DELETE
    @Path("{id}")
    public void deleteCar(@PathParam("id") Long id) {
        carService.deleteCar(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Car> getCars() {
        return carService.getCars();
    }
}
