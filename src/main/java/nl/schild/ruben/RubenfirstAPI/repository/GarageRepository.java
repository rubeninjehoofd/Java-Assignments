package nl.schild.ruben.RubenfirstAPI.repository;

import nl.schild.ruben.RubenfirstAPI.model.Garage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository extends CrudRepository<Garage, Long>
{
}
