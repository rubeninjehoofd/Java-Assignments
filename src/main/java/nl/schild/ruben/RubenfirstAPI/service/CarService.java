package nl.schild.ruben.RubenfirstAPI.service;

import nl.schild.ruben.RubenfirstAPI.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarService
{
    private List<Car> cars = new ArrayList<Car>();

    public CarService()
    {
        cars.add(new Car(1, "Ferrari", "F40", 200000, 1988));
        cars.add(new Car(2, "Tesla", "Model S", 200000, 2017));
        cars.add(new Car(3, "Tesla", "Model X", 11000000, 2018));
    }

    //get all cars
    public List<Car> getAllCars()
    {
        return cars;
    }

    //get car by id
    public Car getCarById(int id)
    {
        return cars.get(id);
    }

    //add car
    public void addCar(Car car)
    {
        cars.add(car);
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
