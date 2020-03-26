package com.ttpsc.service;

import com.ttpsc.entity.Car;
import com.ttpsc.repository.CarRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Inject
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Optional<Car> getCar(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void updateCar(Long id, Car car) {
        Optional<Car> foundCar = carRepository.findById(id);

        if (foundCar.isPresent()) {
            car.setId(foundCar.get().getId());
        }
        carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findByOrderByPriceDesc() {
        return carRepository.findByOrderByPriceDesc();
    }
}
