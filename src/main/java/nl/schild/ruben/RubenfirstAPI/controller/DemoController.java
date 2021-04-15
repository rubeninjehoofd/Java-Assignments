package nl.schild.ruben.RubenfirstAPI.controller;

import nl.schild.ruben.RubenfirstAPI.model.Car;
import nl.schild.ruben.RubenfirstAPI.service.CarService;
import org.springframework.http.MediaType;
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

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String test()
    {
        return "Hello world";
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
}
