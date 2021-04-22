package nl.schild.ruben.RubenfirstAPI.controller;

import nl.schild.ruben.RubenfirstAPI.model.Car;
import nl.schild.ruben.RubenfirstAPI.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController
{
    CarService carService;

    public CarController(CarService carService)
    {
        this.carService = carService;
    }

    //get all cars
    @RequestMapping(value = "/cars", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCars()
    {
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.status(200).body(cars);
    }

    //get car by id
    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCar(@PathVariable Long id)
    {
        try
        {
            Car car = carService.getCarById(id);
            return ResponseEntity.status(200).body(car);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //add new car
    @RequestMapping(value = "/addCar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addCar(@RequestBody Car car)
    {
        try
        {
            carService.addCar(car);
            return ResponseEntity.status(200).body(car);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //delete al cars
    @RequestMapping(value = "/delete/cars", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCars()
    {
        try
        {
            carService.deleteCars();
            return ResponseEntity.status(200).build();
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //delete a car by id
    @RequestMapping(value = "/delete/cars/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCarById(@PathVariable int id)
    {
        try
        {
            carService.deleteCar(id);
            return ResponseEntity.status(200).build();
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //update a car
    @RequestMapping(value = "/update/car/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCar(@PathVariable int id, @RequestBody Car car)
    {
        try
        {
            carService.updateCar(id, car);
            return ResponseEntity.status(201).body(car);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
