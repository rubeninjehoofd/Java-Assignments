package nl.schild.ruben.RubenfirstAPI.service;

import nl.schild.ruben.RubenfirstAPI.model.Car;
import nl.schild.ruben.RubenfirstAPI.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarService
{
    private List<Car> cars = new ArrayList<Car>();

    CarRepository carRepo;

    public CarService(CarRepository carRepo)
    {
        this.carRepo = carRepo;
    }

    //get all cars
    public List<Car> getAllCars()
    {
        return carRepo.findAll();
    }

    //get car by id
    public Car getCarById(Long id)
    {
        return carRepo.getOne(id);
    }

    //add car
    public void addCar(Car car)
    {
        carRepo.save(car);
    }

    //delete all cars
    public void deleteCars()
    {
        for (Car car : cars)
        {
            cars.remove(car);
        }
    }

    //delete a specific car
    public void deleteCar(int id)
    {
        cars.remove(id);
    }

    //update a car
    public void updateCar(int id, Car car)
    {
        cars.set(id, car);
    }
}
