package nl.schild.ruben.RubenfirstAPI.repository;

import nl.schild.ruben.RubenfirstAPI.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long>
{

}
