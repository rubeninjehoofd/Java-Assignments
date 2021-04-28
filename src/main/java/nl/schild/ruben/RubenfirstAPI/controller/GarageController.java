package nl.schild.ruben.RubenfirstAPI.controller;

import nl.schild.ruben.RubenfirstAPI.model.Car;
import nl.schild.ruben.RubenfirstAPI.service.GarageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GarageController
{
    GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    //get cars from garage
    @RequestMapping(value = "/garage/cars", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCarsInGarage()
    {
        try
        {
            List<Car> cars = garageService.getAllCars();
            return ResponseEntity.status(200).body(cars);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //post a car into the garage
    @RequestMapping(value = "/garage/cars", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> addCar(@RequestBody Car car)
    {
        try
        {
            garageService.addCar(car);
            return ResponseEntity.status(200).body(car);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //delete a car by id
    @RequestMapping(value = "/garage/cars/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCarById(@PathVariable Long id)
    {
        try
        {
            garageService.removeCar(id);
            return ResponseEntity.status(200).build();
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //get the number of cars inside the garage
    @RequestMapping(value = "/garage/cars/{model}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> getCarByModel(@PathVariable String modelName)
    {
        try
        {
            Car car = garageService.findCarByModel(modelName);
            return ResponseEntity.status(200).body(car);
        }
        catch(Exception exception)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
