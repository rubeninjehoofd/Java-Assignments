package nl.schild.ruben.RubenfirstAPI.controller;

import nl.schild.ruben.RubenfirstAPI.model.Car;
import nl.schild.ruben.RubenfirstAPI.service.GarageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GarageController
{
    GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    //get a car from a garage
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
    @RequestMapping(value = "/garage/addCar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
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

}
