package nl.schild.ruben.RubenfirstAPI.service;

import nl.schild.ruben.RubenfirstAPI.model.Car;
import nl.schild.ruben.RubenfirstAPI.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GarageService
{
    private List<Car> cars = new ArrayList<Car>();

    CarRepository carRepository;

    public GarageService(CarRepository carRepo)
    {
        this.carRepository = carRepo;
    }


    //get all cars from the garage
    public List<Car> getAllCars()
    {
        return carRepository.findAll();
    }

    //add a new car
    public void addCar(Car car)
    {
        carRepository.save(car);
    }

    //empty a garage spot
    public void removeCar(Long id)
    {
        carRepository.deleteById(id);
    }

    //return a car based on the model name
    public Car findCarByModel(String modelName)
    {
        return carRepository.findCarByModel(modelName);
    }
}
