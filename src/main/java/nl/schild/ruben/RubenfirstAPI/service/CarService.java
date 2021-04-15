package nl.schild.ruben.RubenfirstAPI.service;

import nl.schild.ruben.RubenfirstAPI.model.Car;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class CarService extends JpaRepositoriesAutoConfiguration
{
    private List<Car> cars = new ArrayList<Car>();

    public CarService()
    {
        cars.add(new Car(1, "Ferrari", "F40", 200000, 1988));
        cars.add(new Car(2, "Tesla", "Model S", 200000, 2017));
        cars.add(new Car(3, "Tesla", "Model X", 11000000, 2018));
    }

    public Car getById(int id)
    {
        return cars.get(id);
    }

    public List<Car> getAllCars()
    {
        return cars;
    }

    public Car addCar(Car car)
    {
        cars.add(car);
        return car;
    }

    public void deleteCars()
    {
        for (Car car : cars)
        {
            cars.remove(car);
        }
    }
}
