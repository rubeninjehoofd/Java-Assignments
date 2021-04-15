package nl.schild.ruben.RubenfirstAPI.controller;

import nl.schild.ruben.RubenfirstAPI.model.Car;
import nl.schild.ruben.RubenfirstAPI.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController
{
    CarService carService;

    public DemoController(CarService carService)
    {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public List<Car> getAllCars()
    {
        return carService.getAllCars();
    }

    @PostMapping(value = "/addCar")
    public Car addCar(@RequestBody Car car)
    {
        return carService.addCar(car);
    }

    @DeleteMapping(value = "/deletecars")
    public void deleteCars()
    {
        carService.deleteCars();
    }
}
