package com.ttpsc.service;

import com.ttpsc.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    Optional<Car> getCar(Long id);
    void addCar(Car car);
    void updateCar(Long id, Car car);
    void deleteCar(Long id);
    List<Car> getCars();
}
